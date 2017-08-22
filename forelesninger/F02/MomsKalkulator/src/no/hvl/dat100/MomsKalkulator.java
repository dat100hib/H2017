package no.hvl.dat100;
import static javax.swing.JOptionPane.*;
import static java.lang.String.*;
import static java.lang.Double.*;

public class MomsKalkulator {

	public static void main(String[] args) {
		/* Denne koden kan forbedres når vi har lært mer
		 * 
		 */
		/* Formler
		 * Netto er beløp uten moms
		 * Brutto er beløp med moms
		 * 1. Moms = Netto*MVA/100
		 * 2. Brutto = Netto + Moms
		 * Innsatt for Moms i ligning 2 får vi:
		 * Brutto = Netto + Netto*MVA/100 
		 *         = Netto(1 + MVA/100)		 * 
		 * => Netto = Brutto/(1 + MVA/100)
		 */
		
		final double MVA = 25.0;
		final double FAKTOR = 1 + MVA/100;
		String tallTxt = showInputDialog("Skriv inn beløp:");
		double belop = parseDouble(tallTxt);
		/* Basert på at beløpet du oppgir er uten moms (eksl.meravgift)
		 * *
		 */
		double moms = belop*MVA/100;
		double medMoms = belop + moms; //
	
		String ut1 = "Tolket innlest beløp uten moms " + format("%4.2f",belop) + "\n" + 
		              "Beløpet med moms blir " +  format("%4.2f",medMoms) + " kroner" + "\n" +		
		              "Momsen blir " + format("%4.2f",moms) + " kroner"; 		
		
		showMessageDialog(null,ut1);
		
		// Utskrift til konsoll
		
		System.out.println("Beløpet med moms blir " + format("%4.2f",medMoms));
		System.out.println("Momsen blir " + format("%.2f",moms));
		
		// Basert på at beløpet du oppgir er med moms (inkl. meravgift)
		 
		double utenMoms = belop/FAKTOR;
		moms = belop - utenMoms;
		String ut2 = "Tolket innlest beløp med moms " + format("%4.2f",belop) + "\n" +
		              "Beløpet uten moms blir  " + format("%4.2f",utenMoms) + " kroner" + "\n" +
				      "Momsen blir  " + format("%4.2f",moms) + " kroner"; 		
	
	showMessageDialog(null,ut2);
	
	// Utskrift til konsoll
	
	System.out.println("Beløpet uten moms blir " + format("%.2f",utenMoms));
	System.out.println("Momsen blir " + format("%.2f",moms));
	

	}
	
}
