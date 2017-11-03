package no.hvl.dat100.main;

import no.hvl.dat100.kontroll.Kontroll;
import no.hvl.dat100.modell.EiendomsRegister;
import no.hvl.dat100.utsyn.tekst.*;

public class TekstApplikasjon {

	public static void main(String[] args) {
			
		if (args.length > 0) {
			
			String kommune = args[0];
			
			EiendomsRegister register = new EiendomsRegister(kommune);

			Kontroll kontroll = new Kontroll(register);

			TekstUtsyn utsyn = new TekstUtsyn(kontroll);

			utsyn.kjor();
			
		} else {
			System.out.println("Applikasjonen kunne ikke starte");
		}
	}
}
