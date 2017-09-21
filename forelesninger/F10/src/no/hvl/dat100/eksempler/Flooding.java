package no.hvl.dat100.eksempler;

import easygraphics.EasyGraphics;
import java.util.Scanner;

public class Flooding extends EasyGraphics {

	// nesten dekket hvis mindre en fra havoverflaten
	int NESTEN_DEKKET_INT = 2; 

	char DEKKET_CHR = '~';
	char NESTEN_DEKKET_CHR = 'O';
	char SIKKERT_CHR = '+';

	// terreng hogde
	int[][] terreng = { 	{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
						{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
						{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 } };
			
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("FLOODING", 400,400);

		visualiser(); 
	}

	public void visualiser() {

		System.out.println("Angi havhøyde i tegnevinduet ...");
		int hav = Integer.parseInt(getText("havhøyde"));
		
		while (hav >= 0) {
			
			// TODO - START
			
			// itererer igjennom terreng tabellen
			// skriv rett tegn ut avhenggig av avstand fra havoverflate
			
			// TODO - SLUTT
			
			System.out.print("Hav høyde : ");
		}
	}
}