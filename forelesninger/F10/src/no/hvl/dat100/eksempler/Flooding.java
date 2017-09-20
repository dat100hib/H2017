package no.hvl.dat100.eksempler;

import java.util.Scanner;

public class Flooding {

	// nesten dekket hvis mindre en fra havoverflaten
	static int NESTEN_DEKKET_INT = 2; 

	static char DEKKET_CHR = '~';
	static char NESTEN_DEKKET_CHR = 'O';
	static char SIKKERT_CHR = '+';

	public static void main(String args[]) {

		// terreng hogde
		int[][] terreng = { 	{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
							{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
							{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 } };

		int hav = 0;

		Scanner in = new Scanner(System.in);
		
		while (hav >= 0) {
			

			// TODO - START
			
			// itererer igjennom terreng tabellen
			// skriv rett tegn ut avhenggig av avstand fra havoverflate
			
			// TODO - SLUTT
			
			System.out.print("Hav høyde : ");
			hav = in.nextInt();
		}
		
		in.close();
	}
}