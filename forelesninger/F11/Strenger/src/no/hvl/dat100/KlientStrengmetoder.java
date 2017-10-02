package no.hvl.dat100;

public class KlientStrengmetoder {
	public static void main(String[] args) {
		String streng = "otto";
		if (Strengmetoder.erPalindrom(streng)) {
			System.out.println("\"" + streng + "\" er et palindrom");
		} else {
			System.out.println("\"" + streng + "\" er et ikke palindrom");
		}

		Strengmetoder.delOpp("Ole Olsen:Nygårdsgt 1:5020 Bergen", ":");
		Strengmetoder.delOpp("En streng med flere ord", " ");

		Strengmetoder.skrivMidten("a");
		Strengmetoder.skrivMidten("ab");
		Strengmetoder.skrivMidten("abc");
		Strengmetoder.skrivMidten("1234567");
		Strengmetoder.skrivMidten("12345678");

		// Bruk av noen andre metoder i Stringklassen

		streng = "Hallo";
		String delstreng = "al";

		// - contains
		if (streng.contains(delstreng)) {
			System.out.println("" + streng + " inneholder " + delstreng);
		} else {
			System.out.println("" + streng + "inneholder ikke " + delstreng);
		}

		// indexOf -returnerer posisjonen der delstrengen starter, ellers -1
		if (streng.indexOf(delstreng) != -1) {
			System.out.println("" + streng + " inneholder " + delstreng);
		} else {
			System.out.println("" + streng + "inneholder ikke " + delstreng);
		}

		// charAt returnerer tegnet i posisjoen

		int posisjon = 2;
		char tegn = streng.charAt(posisjon);
		System.out.println("Tegnet i strengen " + "'" + streng + "'" + " i posisjon " + posisjon + " er " + tegn);

	}

	// andre er compareTo, equals, ValeuOf ...

}
