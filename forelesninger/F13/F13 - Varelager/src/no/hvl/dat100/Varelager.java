package no.hvl.dat100;

import java.util.Scanner;
import static javax.swing.JOptionPane.*;
import java.io.*;


public class Varelager {
	public static void finnVarer(Vare[] vTab, int antVarer, String streng) {
		System.out.println("Følgende varer inneholder: " + streng);
		for (int i = 0; i < antVarer; i++) {
			if (vTab[i].getNavn().contains(streng)) {
				vTab[i].vis();
			}
		}
	}
	public static void main(String[] args) throws Exception {
		final int MAX_ANT = 100;
		Vare[] vareliste = new Vare[MAX_ANT];
		String filnavn = "Varedata.txt";
		Scanner leser = new Scanner(new File(filnavn));
		String linje;
		if (leser.hasNextLine()) {
			linje = leser.nextLine(); // Fjerner kolonneoverskriftene
		}
		int i = 0;
		while (leser.hasNextLine()) {
			linje = leser.nextLine();
			String[] vareTab = linje.split(";");
			int nr = Integer.parseInt(vareTab[0]);
			String navn = vareTab[1];
			double pris = Double.parseDouble(vareTab[2]);
			int antall = Integer.parseInt(vareTab[3]);
			vareliste[i++] = new Vare(nr, navn, pris, antall);
		}
		leser.close();
		int antVarer = i; // Ikke sikkert at tabellen er full...
		
		
		String soek = null;
		do {
			soek =  showInputDialog("Varesøk:");
			if (soek != null) {
				finnVarer(vareliste, antVarer, soek);
			}

		} while (soek != null);

	}
}
