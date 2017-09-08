package no.hib.dat100;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
//import static java.lang.String.format;
public class KlientKalkulator {

	public static void main(String[] args) {
		String tallTxt = showInputDialog("Oppgi forste heltall: ");	
		int tall1 = parseInt(tallTxt);
		tallTxt = showInputDialog("Oppgi andre heltall: ");
		int tall2 = parseInt(tallTxt); 
		
		System.out.println("Addisjonen blir  " + Kalkulator.add(tall1, tall2));
		System.out.println("Differansen blir " + Kalkulator.sub(tall1, tall2));
		System.out.println("Produktet blir   " + Kalkulator.mul(tall1, tall2));
		System.out.println("Divisjonen blir  " + Kalkulator.div(tall1, tall2));
		
		int addisjon = Kalkulator.add(tall1, tall2);
		//Formatert utskrift med metoden String.format.
		System.out.println("Addisjonen blir " + String.format("%6d", addisjon));
		//System.out.println("Addisjonen blir " + format("%6d", addisjon));		    
	}
}
