package no.hvl.dat100.unntak.eksempler;

import javax.swing.JOptionPane;

public class HastighetCheck {

	private static boolean ok = true;

	public static void main(String[] args) {

		int km = 0, tm = 0;
	
		String kmstr = JOptionPane.showInputDialog("Avstand i kilometer");

		if (kmstr.matches("\\d+")) {
			km = Integer.parseInt(kmstr); // konverter streng til heltall
		} else {
			ok = false;
			System.out.println("Feil: Kilometer ikke et tall");
		}
		
		if (ok) { // en koding-strategi for å gå videre hvis ikke feil
			String tmstr = JOptionPane.showInputDialog("Tid i timer");

			if (tmstr.matches("\\d+")) {
				tm = Integer.parseInt(tmstr); // konverter streng til heltall

				if (tm != 0) { 
					double hastighet = tm / km;
					System.out.println("Hastighet: " + hastighet); 
				}
				else {
					System.out.println("Feil: tid kan ikke være 0");
				}
			}
			else {
				System.out.println("Feil: tid i timer ikke et tall");
			}
		}
	}
}
