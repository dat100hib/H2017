package no.hvl.dat100;

/*
 *  Testprogram for klassen AnsattSamling.
 */
public class AnsattTest {

	public static void main(String[] args) {

		// Setter av plass til 100 ansatte
		Ansattsamling ansatte = new Ansattsamling(100);

		// Setter inn 3 ansatte etter tur

		Ansatt a = new Ansatt(1, "Jan", "Li", 420000);
		boolean ok = ansatte.settInn(a);
		if (ok) {
			System.out.println("Vellykket innsetting: " + a.toString());
		} else {
			System.out.println("Innsetting feilet: " + a.toString());
		}

		a = new Ansatt(2, "Lise", "Moen", 521000);
		ok = ansatte.settInn(a);
		if (ok) {
			System.out.println("Vellykket innsetting: " + a.toString());
		} else {
			System.out.println("Innsetting feilet: " + a.toString());
		}
		a = new Ansatt(3, "Kari", "Enger", 477000);
		ok = ansatte.settInn(a);
		if (ok) {
			System.out.println("Vellykket innsetting: " + a.toString());

		} else {
			System.out.println("Innsetting feilet: " + a.toString());
		}

		// Viser innholdet av ansatt-samlingen
		System.out.println(ansatte.toString());

		// Søker fram en ansatt og oppdaterer lønnen
		a = ansatte.finn(2);
		if (a != null) {
			a.setLoenn(440000);
		} else {
			System.out.println("Fant ikke ansatt!");
		}
		// Merk at ansatt-samlingen er oppdatert
		System.out.println(ansatte.toString());

		// Sletter ansatt 2
		ok = ansatte.slett(2);
		if (ok) {
			System.out.println("Vellykket sletting: " + a.toString());
		} else {
			System.out.println("Sletting feilet: " + a.toString());
		}
		System.out.println(ansatte.toString());
	}

}
