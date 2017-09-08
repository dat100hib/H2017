package no.hib.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class KlientTall {

	public static void main(String[] args) {
				
		String tallTxt = showInputDialog("Skriv inn første tall:");
		int tall1 = parseInt(tallTxt);
		tallTxt = showInputDialog("Skriv inn andre tall:");
		int tall2 = parseInt(tallTxt);
		tallTxt = showInputDialog("Skriv inn tredje tall:");
		int tall3 = parseInt(tallTxt);
		
		int storst = Tall.storst(tall1, tall2, tall3); // Metodekall
		
		String melding = "Storste tall blir " + storst;
		
		showMessageDialog(null, melding);
	    //Bytter ikke
		
	    int x = 10;
	    int y = 20;
	    Tall.bytte(x, y);
	    System.out.println(x);
	    System.out.println(y);
		
		//...Fyll ut for de andre metodene))
	    System.out.println();
	    
	    //Bytter
	    int temp = x;
	    x = y;
	    y = temp;
	    System.out.println(x);
	    System.out.println(y);
	    	

	}
}


