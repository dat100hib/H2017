package no.hvl.dat100.modell;

import java.util.ArrayList;


/**
 * Simpel test klasse for eiendomsregister.
 * @author Lars Kristensen
 * @version 1.0
 */
public class EiendomTester {

	public static void main(String[] args) {

		// opprett test objekter
		EiendomsRegister register = new EiendomsRegister("bergen");
		
		NeringsEiendom ne = new NeringsEiendom(10,10,202020);
		UtleieEiendom ue = new UtleieEiendom(10,20,1096,10000);
		
		register.registrerEiendom(ne);
		register.registrerEiendom(ue);
		
		KontaktAdresse ka1 = new KontaktAdresse("Nymarksveien", 42, 5020, "Bergen", "Norge");
		KontaktAdresse ka2 = new KontaktAdresse("Fyllingsveien", 84, 5120, "Fyllingen", "Bahamas");
		
		Eier bente = new Eier("Bente Rask", 1741, ka1);
		Eier odd = new Eier("Odd Vanden", 1560, ka2);
		
		register.registrerEier(bente, 10,10);
		register.registrerEier(odd, 10, 20);
		
		ne.registrerNabo(ue);
		ue.registrerNabo(ne);
		
		// hent ut informasjon og sjekk
		System.out.println(register.finnEiendom(10, 10) == ne);
		ArrayList<Eier> neeiere = register.finnEiendom(10, 10).getEiere();
		
		System.out.println(neeiere.size() == 1);
		System.out.println(neeiere.get(0) == bente);

		System.out.println(register.finnEiendom(10, 20) == ue);
		ArrayList<Eier> ueeiere = register.finnEiendom(10, 20).getEiere();
		
		System.out.println(ueeiere.size() == 1);
		System.out.println(ueeiere.get(0) == odd);
	}

}
