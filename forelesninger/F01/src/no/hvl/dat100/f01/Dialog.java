package no.hvl.dat100.f01;

import static javax.swing.JOptionPane.*;

public class Dialog {

	public static void main(String[] args) {
		
		String navn = showInputDialog("Navn: ");
		showMessageDialog(null, "Hei " + navn);
	}
}