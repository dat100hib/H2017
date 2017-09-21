package no.hvl.dat100.eksempler;

import easygraphics.EasyGraphics;

public class Flooding extends EasyGraphics {

	// nesten dekket hvis mindre en fra havoverflaten
	int NESTEN_DEKKET = 1; 
	int RADIUS = 20;
	int MARGIN = 50;
	
	// terreng hogde
	int[][] terreng = { 	{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
						{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
						{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 } };
			
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("FLOODING", 800,300);

		visualiser(); 
	}

	public void visualiser() {

		System.out.println("Angi havhøyde i tegnevinduet ...");
		int hav = Integer.parseInt(getText("havhøyde"));
		
		while (hav >= 0) {
			
			// TODO - START
			for (int ri = 0; ri<terreng.length; ri++) {
				
				for (int ki = 0; ki <terreng[ri].length; ki++) {
					
					int h = terreng[ri][ki];
					
					if (hav >= h) {
						// under vann
						setColor(0,0,255);
					} else if ((h - hav) > NESTEN_DEKKET) {
						// sikkert
						setColor(222,184,135);
					} else {
						// usikkert
						setColor(255,140,0);
					}

					fillCircle(MARGIN + ki * 2 * RADIUS,MARGIN + ri * 2* RADIUS,RADIUS);

				}
			}
			// itererer igjennom terreng tabellen
			// skriv rett tegn ut avhenggig av avstand fra havoverflate
			
			// TODO - SLUTT
			System.out.println("Angi havhøyde i tegnevinduet ...");
			hav = Integer.parseInt(getText("havhøyde"));
		}
	}
}