package no.hvl.dat100;

import java.util.Arrays;

public class FinnMinste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] tallene = { 71, 67, -35, -4, 83, 77, 12, 19 };
        
		int minsteHittil = tallene[0]; // tallene[0] er første tallet i listen
		for (int nesteTall : tallene) {
			if (nesteTall < minsteHittil) {
				minsteHittil = nesteTall;
			}
		}
		System.out.println("Tallene: " + Arrays.toString(tallene));
		System.out.println("Det minste tallet er " + minsteHittil);

	}

}

