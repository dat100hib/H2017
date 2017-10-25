package no.hvl.dat100.utsyn.tekst;

import java.util.Scanner;

// hjelpeklasse for innlesning av gårds- og bruksnummer
public class EID {

	int gns; // OVERVEI private og get-metode
	int bns;

	public void readEID(Scanner leser) {
		System.out.println("Gårdsnummer : ");
		gns = leser.nextInt();

		System.out.println("Bruksnummer : ");
		bns = leser.nextInt();
	}
}
