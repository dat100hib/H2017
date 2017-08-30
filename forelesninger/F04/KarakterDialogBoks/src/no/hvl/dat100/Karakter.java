package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class Karakter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String melding = "";
		String karakter = showInputDialog("Oppgi en karakter A..F [STORE BOKSTAVER] ");

		switch (karakter) {
			case "A":
				melding = "Svært bra";
				break;
			case "B":
				melding = "Meget bra";
				break;
			case "C":
				melding = "Bra";
				break;
			case "D":
				melding = "Noe bra";
				break;
			case "E":
				melding = "Lite bra";
			case "F":
				melding = "Ikke bra";
				break;
			default:
				melding = "ugyldig karakter";
		}		
		showMessageDialog(null, melding);
	}

}
