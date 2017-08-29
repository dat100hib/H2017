package no.hval.dat100;

import java.util.Scanner;

public class Eksamensform2 {

	public static void main(String[] args) {
		int antallStudenter;
		Scanner tastatur = new Scanner(System.in);
		System.out.print("Oppgi antall oppmeldte studenter: ");
		antallStudenter = tastatur.nextInt();
		if (antallStudenter < 5) {
			  System.out.println("Kurset er avlyst.");
		} else if (antallStudenter < 10) {
			   System.out.println("Kurset går med muntlig eksamen.");
		} else if (antallStudenter < 40) {
			   System.out.println("Kurset går med skriftlig eksamen.");
		} else {
			   System.out.println("Kurset deles i flere klasser.");
		}
		System.out.println("Antall oppmeldte studenter er " + antallStudenter);
	}
}
