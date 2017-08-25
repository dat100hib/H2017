package no.hvl.no;
import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
public class Avstand {

	public static void main(String[] args) {
		// (1,4) og ((5,1) skal gi 5 (5.00)
		String tekst = "Programmet leser to heltallskoordinater og beregner avstanden" + "\n";
		showMessageDialog(null,tekst);
		//Innlesing av x1,y1
		String tallTxt = showInputDialog("Skriv inn x1: ");
		int x1 = parseInt(tallTxt);
		tallTxt = showInputDialog("Skriv inn y1:");
		int y1 = parseInt(tallTxt);
		//Innlesing av x2,y2
		 tallTxt = showInputDialog("Skriv inn x2: ");
		int x2 = parseInt(tallTxt);
		tallTxt = showInputDialog("Skriv inn y2: ");
		int y2 = parseInt(tallTxt);
		//Utskrift
		double avstand = sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		String ut1 = "Avstanden mellom ("+x1+","+y1 +")" + " og ("+x1+","+y1 +")" + " er "  + format("%4.2f",avstand);
	showMessageDialog(null,ut1);

	}

}
