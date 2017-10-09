package no.hvl.dat100.unntak.eksempler;

import javax.swing.JOptionPane;

public class Hastighet {

	public static void main(String[] args) {

		String kmstr = JOptionPane.showInputDialog("Avstand i kilometer");
		int km = Integer.parseInt(kmstr); // konverter streng til heltall

		String tmstr = JOptionPane.showInputDialog("Tid i timer");
		int tm = Integer.parseInt(tmstr); // konverter streng til heltall

		double hastighet = km/tm;
		
		System.out.println("Hastighet: " + hastighet);
		
	}
}