package no.hib.dat100;

public class Tall {

	public static int minst(int a, int b) {
		int minste = a;
		if (b < minste) {
			minste = b;
		}
		return minste;
	}

	public static int minst(int a, int b, int c) {
		int minste = a;

		if (b < minste) {
			minste = b;
		}
		if (c < minste) {
			minste = c;
		}
		return minste;
	}

	public static int storst(int a, int b) {
		int storste = a;
		if (b > storste) {
			storste = b;
			return storste;
		}
		return storste;
	}

	public static int storst(int a, int b, int c) {
		int storste = a;

		if (b > storste) {
			storste = b;
		}
		if (c > storste) {
			storste = c;
		}
		return storste;
	}

	public static int sum(int fra, int til) {
		// Finner summen av heltall
		int summen = (fra + til) * (til - fra + 1) / 2;
		return summen;
	}
	
	

	// Hva med bytte????????? Går ikke med pga verdioverføring når primitive
	// typer
	// Vi kan teste.
	// stackoverflow.com/questions/3624525/how-to-write-a-basic-swap-function-in-java

	public static void bytte(int a, int b) {
		// Vil den virke???
		int temp = a;
		a = b;
		b = temp;
	}
}
