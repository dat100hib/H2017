package no.hvl.dat100;
import static java.lang.Double.*;
import static java.lang.String.*;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class UkeLonn {

	public static void main(String[] args) {
		// Normaluke er 37.5 timer. Lonn for en normaluke er 12000kr.
		// Overtidsbetaling er 500kr pr. time for alle timer over 37.5
		// Hvis antall timer er over 52 timer, utbetales et ekstra tillegg på 4000kr
		final double NORMALUKE = 37.5;   // overtid alt over 37.5 timer
		final double TILLEGG = 4000.0; // fast tillegg utover 52 timer
		double antallTimer;
		double ukelonn;
		String tallTxt = showInputDialog("Oppgi et antall timer");
		antallTimer = parseDouble(tallTxt);
		if (antallTimer <= NORMALUKE) {     // antallTimer <= 37.5
			ukelonn = 12000.0;
		} else if (antallTimer <= 52.0) {   // 37.5 < antallTimer < = 52
			ukelonn = 12000.0 + (antallTimer - NORMALUKE) * 500.0;
		} else {                           // antallTimer > 52.0
			ukelonn = 12000.0 + (antallTimer - NORMALUKE) * 500.0 + TILLEGG;
		}
		String utTxt = "Ukelonnen er " + format("%10.2f",ukelonn) + "\n";
		showMessageDialog(null,utTxt);
	}
}