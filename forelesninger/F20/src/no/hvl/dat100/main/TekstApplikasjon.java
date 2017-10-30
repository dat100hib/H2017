package no.hvl.dat100.main;

import no.hvl.dat100.utsyn.tekst.*;

public class TekstApplikasjon {

	// startpunkt for eiendomsregister applikasjonen
	public static void main(String[] args) {
	
		TekstUtsyn utsyn = new TekstUtsyn();
					
		// start grensesnitt og brukerinteraksjon
		Applikasjon.start(utsyn,args);
	}
}
