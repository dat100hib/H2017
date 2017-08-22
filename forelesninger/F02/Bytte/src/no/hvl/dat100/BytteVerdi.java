package no.hvl.dat100;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
public class BytteVerdi {

	public static void main(String[] args) {
		
		//Innlesing
		String tallTxt = showInputDialog("Oppgi første verdi");
		int x = parseInt(tallTxt);
		tallTxt = showInputDialog("Oppgi andre verdi");
		int y = parseInt(tallTxt);
		String utTxt = "x " + x + "\n" +
				       "y " + y;
		showMessageDialog(null,utTxt);
		
		//Bytting
		int temp = x;
		x = y;
		y = temp;
		
		//utskrift
		utTxt = "x " + x + "\n" +
			     "y " + y;
	    showMessageDialog(null,utTxt);		

	}

}
