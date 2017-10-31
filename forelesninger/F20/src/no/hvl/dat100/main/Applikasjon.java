package no.hvl.dat100.main;

import no.hvl.dat100.kontroll.Kontroll;
import no.hvl.dat100.modell.EiendomsRegister;

public class Applikasjon {

	public static void start(IUtsyn utsyn, String[] args) {

		String kommune = args[0];

		// opprett et register
		EiendomsRegister register = new EiendomsRegister(kommune);

		// opprett kontroll knytttet til register
		Kontroll kontroll = new Kontroll(register);

		// sett kontroll objekt for utsyn
		utsyn.setKontroll(kontroll);

		// start grensesnitt og brukerinteraksjon
		utsyn.kjor();
	}
}
