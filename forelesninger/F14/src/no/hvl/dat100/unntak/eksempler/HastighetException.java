package no.hvl.dat100.unntak.eksempler;

import javax.swing.JOptionPane;

public class HastighetException {

	public static void main(String[] args) {
		System.out.println("Starter main().");

		try {
			String kmstr = JOptionPane.showInputDialog("Avstand i kilometer");
			int km = Integer.parseInt(kmstr); // konverter streng til heltall

			String tmstr = JOptionPane.showInputDialog("Tid i timer");
			int tm = Integer.parseInt(tmstr); // konverter streng til heltall

			double hastighet = km/tm;
			System.out.println("Hastighet: " + hastighet);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Feil: Kilometer ikke et tall" + e.getMessage());
		} catch (ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "Feil: tid kan ikke være 0" + e.getMessage());
		}

		System.out.println("Returnerer fra main().");
	}
}
