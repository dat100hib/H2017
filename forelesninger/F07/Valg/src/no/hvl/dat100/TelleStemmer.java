package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class TelleStemmer {
	/*
	 * Søk etter streng i tabell av strengar. Dersom streng finst, returner
	 * indeks (posisjon) i tabellen. Dersom den ikkje finst, returner -1.
	 */

	// TODO

	
	/*
	 * Har tabell av heiltal. Lag ein metode for å finn posisjon for største talet. Om er er fleire
	 * like, bruk den første av dei
	 */
	public static int maks(int[] tab) {
		int makspos = 0;
		for (int i = 1; i < tab.length; i++) {
			if (tab[i] > tab[makspos]) {
				makspos = i;
			}
		}
		return makspos;
	}
	
	// TODO

	
	public static String lesStemme() {
		return showInputDialog("Parti?");
	}

	public static void main(String[] args) {
		/*
		 * Deklarer og opprett partitabell. Ta med berre dei som ligg an til å
		 * få mandat "Ap", "Frp", "H", "KrF", "MDG", "R", "Sp", "SV", "V"
		 * 
		 */
		String[] partier = {"Ap", "Frp", "H", "KrF", "MDG", "R", "Sp", "SV", "V"};
		final int ANTALL_PARTI = partier.length;
	
		// Deklarer tabell for å telje stemmer
		int[] stemmer = new int[ANTALL_PARTI];

		// Gi alle parti ei stemme.
		for (int i = 0; i < ANTALL_PARTI; i++){
			stemmer[i]++;
		}
		
		// Gi ei stemme til MDG
		stemmer[4]++;
		
		// Gi to stemmer til siste partiet i tabellen
		stemmer[ANTALL_PARTI - 1] += 2;
		// stemmer[ANTALL_PARTI - 1] = stemmer[ANTALL_PARTI - 1] + 2;

		// Les inn 5 stemmer og oppdater stemmetabell
		

		// Vis partiet med stemmetal som har fått flest stemmer i eit
		// dialogvindu
		
		stemmer[4] += 3;
		int makspos = maks(stemmer);
		String utstreng = String.format("%s fikk flest stemmer (%d)", partier[makspos], stemmer[makspos]);
		showMessageDialog(null, utstreng);
		
		

		// Skriv ut stemmetabell til konsollvindu
		/*
		 * Ap	5
		 * Frp	5
		 * ...
		 * V	5
		 */
		
		for (int i = 0; i < ANTALL_PARTI; i++) {
			String ut = String.format("%-3s%5d", partier[i], stemmer[i]);
			System.out.println(ut);
		}
		
	}

}
