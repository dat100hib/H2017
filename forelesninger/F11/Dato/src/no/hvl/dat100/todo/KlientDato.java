package no.hvl.dat100.todo;

public class KlientDato {

	public static void main(String[] args) {
		// Lager noen objekter med noen verdier
		// i stedet for innlesing

		Dato d1 = new Dato(2018, 2, 28);
		System.out.println("d1: " + d1.toString());

		Dato d2 = new Dato("10.03.2018");
		System.out.println("d2: " + d2.toString()); // Kall

		System.out.print("d1: " + d1.toString() + " er ");
		if (d1.lovlig()) { // Kall
			System.out.println("en lovlig dato");
		} else {
			System.out.println("er ikke en lovlig dato");
		}
		System.out.print(d1.toString() + " kommer "); // Kall
		if (d1.foer(d2)) { // Kall
			System.out.println("foer " + d2.toString()); // Kall
		} else {
			System.out.println("etter " + d2.toString()); // Kall
		}
		System.out.print("De to datoene er ");
		if (d1.lik(d2)) { // Kall
			System.out.println("like.");
		} else {
			System.out.println("ikke like.");
		}

	}

}
