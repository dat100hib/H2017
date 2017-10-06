package no.hvl.dat100.kontrollflytt;

// Unntakk:
// - 
public class KontrollFlytt {

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

		System.out.println("metode 2 - slutt");
	}
}
