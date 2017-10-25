package no.hvl.dat100.utsyn.tekst;

import java.util.Scanner;

// hjelpeklasse for innlesning av gårds- og bruksnummer
public class Leser {

	private Scanner leser;
	
	public Leser() {
		leser = new Scanner(System.in);
	}
	
	public int lesInt(String tekst) {
		
		System.out.println(tekst);
		
		int tall = leser.nextInt();
		
		return tall;
	}
	
	public String lesStreng(String tekst) {
		
		System.out.println(tekst);
		
		String s = leser.nextLine();
		
		return s;
	}
}
