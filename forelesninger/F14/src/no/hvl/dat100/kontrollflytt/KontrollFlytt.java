package no.hvl.dat100.kontrollflytt;

import java.io.IOException;
import java.lang.RuntimeException;

// Unntakk:
// - IOException
// - RunTimeException

public class KontrollFlytt {

	static boolean somethingbadhappens = true;

	public static void main(String[] args) {

		System.out.println("main - start");
		metode1();
		System.out.println("main - slutt");
	}

	public static void metode1() {
		System.out.println("metode 1 - start");

		metode2();

		System.out.println("metode 1 - slutt");
	}

	public static void metode2() {
		System.out.println("metode 2 - start");

		if (somethingbadhappens) {
			throw (new RuntimeException("Houston we have a problem!"));
		}

		System.out.println("metode 2 - slutt");
	}
}
