package no.hvl.dat100;
import static javax.swing.JOptionPane.*;
import static java.lang.Double.*;
public class KuleVolum {

	public static void main(String[] args) {
		String fortekst = "Volumet av en kule med radius ";
		final double PI = 3.14;
		double volum;
		double radius;
			
	     //Innlesing
		 String tallTxt = showInputDialog("Oppgi radius til kule ");
		//Beregning
		 radius = parseDouble(tallTxt);
		 volum = (4 * PI * radius * radius * radius) / 3;		
		 //Utskrift
		 String utTxt = "Kulevolum " + volum + "\n" +
			            "Radius " + radius;					
		showMessageDialog(null,utTxt);
	}

}
