package no.hvl.dat100;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Dialog {

	public static void main(String[] args) {
				
	     //Innlesing
		 String tallTxt = showInputDialog("Oppgi et heltall");
		 int tall = parseInt(tallTxt);
		 //Utskrift
		 String utTxt = "Tallet er " + tall;			               		
		 showMessageDialog(null,utTxt);
	}

}


