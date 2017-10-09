package no.hvl.dat100.unntak.eksempler;

import javax.swing.JOptionPane;

public class HastighetException {

	public static void main(String[] args) {

		try {
			String kmstr = JOptionPane.showInputDialog("Avstand i kilometer");
			int km = Integer.parseInt(kmstr); 

			String tmstr = JOptionPane.showInputDialog("Tid i timer");
			int tm = Integer.parseInt(tmstr); 

			double hastighet = (double)km/tm;
			System.out.println("Hastighet: " + hastighet);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Feil: Kilometer ikke et tall");
		} catch (ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "Feil: tid kan ikke være 0");
		}
	}
}
