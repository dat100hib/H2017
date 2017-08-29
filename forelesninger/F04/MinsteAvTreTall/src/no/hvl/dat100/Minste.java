package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Minste {
	public static void main(String[] args) {
		//Leser inn 3 heltall, finner det minste og skriver det ut
		
		String tallTxt = showInputDialog("Oppgi verdi til det forste tallet :");
		int tall1 = parseInt(tallTxt);
		tallTxt = showInputDialog("Oppgi verdi til det andre tallet :");
		int tall2 =  parseInt(tallTxt);
		tallTxt = showInputDialog("Oppgi antall det tredje tallet : ");
		int tall3 = parseInt(tallTxt);	
		
		int minste = tall1;
		
		if(tall2 < minste){
			minste = tall2;
		}
		if(tall3 < minste){
			minste = tall2;
		}
		
		String melding = " Det minste tallet av " + tall1+"," + tall2+"," + tall3 + 
				          " er " + minste;
		
		showMessageDialog(null, melding);		

	}
}
