package no.hvl.dat100;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Summen {
	public static void main(String[] args) {
		
		int sum1 = 0; // OBS! En lokal variabel må gis verdi før vi bruker den
		int sum2 = 0;
		boolean gyldigInndata;
		String tallTxt ="";
		String feilmelding = "Feil inndata. Tallet er ikke et tall mellom 2 og 20.";
		String melding = "Tast inn n (et tall mellom 2 og 20): ";
		int n = 0;
		
		/* do-while-løkke ved innlesing */
		do {
			tallTxt = showInputDialog(null, melding);
			n = parseInt(tallTxt);
			gyldigInndata = (n >= 2) && (n <= 20);
			if (!gyldigInndata) {
				showMessageDialog(null, feilmelding);
			}
		} while (!gyldigInndata);

		/* while-løkke ved summering */
		int teller = 1;
		while (teller < n) {
			sum1 = sum1 + teller;
			System.out.print(teller + " + ");
			teller = teller + 1; 
		}
		System.out.println(n + " = " + (sum1 + n));

		/* for-løkke ved summering */
		for (int i = 1; i < n; i++) { // evt.i = i + 1
			sum2 = sum2 + i; 
			System.out.print(i + " + ");
		}
		System.out.println(n + " = " + (sum2 + n));

	}

}
