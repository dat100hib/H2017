package no.hvl.dat100.unntak.eksempler;

import javax.swing.JOptionPane;

public class HastighetSikker {

	public static void main(String[] args) {

		boolean ok = true;

		do {

			try {
				String kmstr = JOptionPane.showInputDialog("Avstand i kilometer");
				int km = Integer.parseInt(kmstr); 

				String tmstr = JOptionPane.showInputDialog("Tid i timer");
				int tm = Integer.parseInt(tmstr); 

				int hastighet = km / tm;
				System.out.println("Hastighet: " + hastighet);
				ok = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Feil: Kilometer ikke et tall");
				ok = false;
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(null, "Feil: tid kan ikke være 0");
				ok = false;
			}
		} while (!ok);
	}
}
