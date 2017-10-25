package no.hvl.dat100.kontroll;

import no.hvl.dat100.modell.EiendomsRegister;
import no.hvl.dat100.utsyn.tekst.*;

public class Applikasjon {

	// startpunkt for eiendomsregister applikasjonen
	public static void main(String[] args) {

		if (args.length == 1) {

			// opprett et register
			EiendomsRegister register = new EiendomsRegister(args[0]);

			// opprett kontroll knytttet til register
			Controller controller = new Controller(register);

			// opprett grensesnitt (user interface) knyttet til kontroll
			TekstUtsyn utsyn = new TekstUtsyn(controller);

			// start grensesnitt og brukerinteraksjon
			utsyn.kjor();
			
		} else
			System.out.println("FEIL: Angi kommunenavn ved start");
	}
}
