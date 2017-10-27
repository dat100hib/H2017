package no.hvl.dat100.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import no.hvl.dat100.lagring.Lagring;
import no.hvl.dat100.modell.EiendomsRegister;
import no.hvl.dat100.modell.Eier;
import no.hvl.dat100.modell.KontaktAdresse;
import no.hvl.dat100.modell.NeringsEiendom;
import no.hvl.dat100.modell.UtleieEiendom;

public class TestEiendom {

	@Test
	public void test() {

		// opprett test objekter
		EiendomsRegister register = new EiendomsRegister("bergen");

		NeringsEiendom ne = new NeringsEiendom(10, 10, 202020);
		UtleieEiendom ue = new UtleieEiendom(10, 20, 1096, 10000);

		register.registrerEiendom(ne);
		register.registrerEiendom(ue);

		KontaktAdresse ka1 = new KontaktAdresse("Nymarksveien", 42, 5020, "Bergen", "Norge");
		KontaktAdresse ka2 = new KontaktAdresse("Fyllingsveien", 84, 5120, "Fyllingen", "Bahamas");

		Eier bente = new Eier("Bente Rask", 1741, ka1);
		Eier odd = new Eier("Odd Vanden", 1560, ka2);

		register.registrerEier(bente, 10, 10);
		register.registrerEier(odd, 10, 20);

		ne.registrerNabo(ue);
		ue.registrerNabo(ne);

		// hent ut informasjon og sjekk
		assertEquals(register.finnEiendom(10, 10), ne);
		ArrayList<Eier> neeiere = register.finnEiendom(10, 10).getEiere();

		assertEquals(neeiere.size(), 1);
		assertEquals(neeiere.get(0), bente);

		assertEquals(register.finnEiendom(10, 20), ue);
		ArrayList<Eier> ueeiere = register.finnEiendom(10, 20).getEiere();

		assertEquals(ueeiere.size(), 1);
		assertEquals(ueeiere.get(0), odd);
		
		Lagring.skriv(register, "testregister.dat");
	}

}
