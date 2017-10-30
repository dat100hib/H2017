package no.hvl.dat100.main;

import no.hvl.dat100.utsyn.gui.GUIUtsyn;

public class GUIApplikasjon {

	// startpunkt for eiendomsregister applikasjonen
	public static void main(String[] args) {
		
		GUIUtsyn utsyn = new GUIUtsyn();
					
		// start grensesnitt og brukerinteraksjon
		Applikasjon.start(utsyn,args);
	}
}
