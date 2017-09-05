package no.hib.dat100;

import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

//Sml. F02-MomsKalkulator der all kode var i main-klassen
public class KlientMoms {

	public static void main(String[] args) {
		String tallTxt = showInputDialog("Skriv inn beløp:");
		double belop = parseDouble(tallTxt);
		/*
		 * Basert på at beløpet du oppgir er uten moms (eksl.meravgift) *
		 */

		double moms = MomsKalkulator.beregnMomsAvNetto(belop);// metodekall
		double medMoms = belop + moms;
		String ut1 = "Tolket innlest beløp uten moms " + format("%8.2f", belop) + "\n" + "Beløpet med moms blir "
				+ format("%8.2f", medMoms) + " kroner" + "\n" + "Momsen blir " + format("%8.2f", moms) + " kroner";

		showMessageDialog(null, ut1);

		// Basert på at beløpet du oppgir er med moms (inkl. meravgift)

		double utenMoms = MomsKalkulator.beregnNetto(belop); // Metodekall
		moms = belop - utenMoms;
		String ut2 = "Tolket innlest beløp med moms " + format("%8.2f", belop) + "\n" + "Beløpet uten moms blir  "
				+ format("%8.2f", utenMoms) + " kroner" + "\n" + "Momsen blir  " + format("%4.2f", moms) + " kroner";

		showMessageDialog(null, ut2);
	}
}
