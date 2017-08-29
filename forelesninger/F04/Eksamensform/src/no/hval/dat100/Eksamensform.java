package no.hval.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Eksamensform {
	public static void main(String[] args) {
		String melding = "";
		String tallTxt = showInputDialog("Oppgi antall oppmeldte studenter: ");
		int antallStudenter = parseInt(tallTxt);
		if (antallStudenter < 5) { // antall < 5
			melding = "Kurset er avlyst.";
		} else if (antallStudenter < 10) { // 5 <= antall < 10
			melding = "Kurset går med muntlig eksamen.";
		} else if (antallStudenter < 40) { // 10 <= antall < 40
			melding = "Kurset går med skriftlig eksamen.";
		} else {
			melding = "Kurset deles i flere klasser."; // antall >=40
		}
		melding = melding + "\n" + "Antall oppmeldte studenter er " + antallStudenter;
		showMessageDialog(null, melding);
	}
}
