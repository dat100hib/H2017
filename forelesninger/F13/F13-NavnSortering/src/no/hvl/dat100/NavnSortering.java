package no.hvl.dat100;

import static java.lang.System.*;
import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

public class NavnSortering {

	public static void main(String[] args) throws Exception {
		String navnefil = args[0];
		skrivSortert(navnefil);
	}

	public static void skrivSortert(String filnavn) throws Exception {

		Scanner leser = new Scanner(new File(filnavn));

		// Antall navn ligger på første linje:
		int antNavn = parseInt(leser.nextLine());

		String[] navnTab = new String[antNavn];

		for (int pos = 0; pos < antNavn; pos++)
			navnTab[pos] = leser.nextLine();

		leser.close();

		Arrays.sort(navnTab);

		String utfil = "sortert.txt";
		PrintWriter skriver = new PrintWriter(utfil);
		
		for (String navn : navnTab) {
			skriver.println(navn);
		}
				
		skriver.close();

	}

}
