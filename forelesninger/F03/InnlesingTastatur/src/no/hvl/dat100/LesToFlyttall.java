package no.hvl.dat100;

import java.util.Scanner;

public class LesToFlyttall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double tall1;
		double tall2;
		Scanner tastatur = new Scanner(System.in);
		System.out.print("Oppgi verdien til x: ");
		tall1 = tastatur.nextDouble();
		System.out.print("Oppgi verdien til y: ");
		tall2 = tastatur.nextDouble();
		double produkt = tall1*tall2;
		System.out.println("Produktet av x og y er " + produkt);

	}

}