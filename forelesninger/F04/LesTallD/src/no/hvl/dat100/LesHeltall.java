package no.hvl.dat100;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class LesHeltall {

	public static void main(String[] args) {
		String melding ="";
		String tallTxt =showInputDialog("Oppgi et heltall");
		int tall = parseInt(tallTxt);
		if (tall < 50) {
			melding = "Mindre enn 50";
		} else if (tall < 100) {
			melding = "Minst 50 og mindre enn 100";
		} else if (tall < 200) {
			melding = "Minst 100 og mindre enn 200";
		} else {
			melding = "Minst 200";
		}
        showMessageDialog(null, melding);
	}

}

