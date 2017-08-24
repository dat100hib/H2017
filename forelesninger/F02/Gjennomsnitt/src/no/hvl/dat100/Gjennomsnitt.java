package no.hvl.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Gjennomsnitt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String ledetekst = "Programmet skal lese inn 3 heltall mindre enn 100 og beregner gjennomsnitt";
		//Test gjerne ut med heltallene 7,3 og 3
		showMessageDialog(null,ledetekst);
		String tallTxt = showInputDialog("Oppgi første tallverdi");
		 int tall1 = parseInt(tallTxt);
		 tallTxt = showInputDialog("Oppgi andre tallverdi");
		 int tall2 = parseInt(tallTxt);
		 tallTxt = showInputDialog("Oppgi tredje tallverdi");
		 int tall3 = parseInt(tallTxt);
		 int sum = tall1+tall2+tall3;
		 double snitt1 = sum/3;            //riktig?
		 double snitt2 = (double)(sum/3);  //riktig?
		 double snitt3 = ((double)sum)/3;
		 double snitt4 = sum/3.0;
		 
		 showMessageDialog(null, "Summen av de 3 innleste tall er "+ sum + "\n" +				
				                 "Gjennomsnitt1 " + snitt1 + "\n" +
				                 "Gjennomsnitt2 " + snitt2 + "\n" +
				                 "Gjennomsnitt3 " + snitt3 + "\n" +
		                         "Gjennomsnitt4 " + snitt4 + "\n" );	             
		  	     
	}

}
