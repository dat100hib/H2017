package no.hvl.dat100.eksempler;

import easygraphics.EasyGraphics;

public class Kino extends EasyGraphics {

	final int ANT_SALER = 2;
	final int ANT_FILMER = 3;
	final int ANT_RADER = 15;
	final int ANT_SETER = 20;
	
	boolean[][] opptatt = new boolean[ANT_RADER][ANT_SETER]; // 15 rader med 20 seter;
			
	boolean[][][] filmer = new boolean[ANT_FILMER][ANT_RADER][ANT_SETER]; // 3 filmer 
			
	boolean[][][][] saler = new boolean[ANT_SALER][ANT_FILMER][ANT_RADER][ANT_SETER]; // 2 saler

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("KINO RESERVASJON", 800,400);
		
		int i = 5; 	
		do {
			reserver(); 
			i--;
		} while (i>0);
		
	}

	int RADIUS = 10;
	int MARGIN = 50;

	public void visReservasjoner(boolean[][] opptatt) {

		for (int radnr = 0; radnr<ANT_RADER; radnr++) {
			
			for (int setenr = 0; setenr<ANT_SETER; setenr++) {
				if (opptatt[radnr][setenr]) {
					setColor(255,0,0); // green
				} else {
					setColor(0,255,0); // rød
				}	
			
			
			fillCircle(MARGIN + setenr * 2 * RADIUS,MARGIN + radnr * 2* RADIUS,RADIUS);
			
			}
		}	
	}

	public void reserver() {
		
		System.out.println("Angi sal i tekstvinduet...");
		int salnr = Integer.parseInt(getText("sal"));
		
		System.out.println("Angi film i tekstvinduet...");
		int filmnr = Integer.parseInt(getText("film"));

		boolean[][] opptatt = saler[salnr][filmnr];
		
		visReservasjoner(opptatt);
		
		System.out.println("Angi rad i tekstvinduet...");
		int radnr = Integer.parseInt(getText("rad"));
		
		System.out.println("Angi sete i tekstvinduet...");
		int setenr = Integer.parseInt(getText("sete"));
	
		opptatt[radnr][setenr] = true;
		
		visReservasjoner(opptatt);
	}

}
