package no.hvl.dat100.mybrowser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GoBtnListener implements ActionListener {

	private JTextArea webpagetextarea;
	private JTextField urltextfield;

	public GoBtnListener(JTextArea webpagetextarea, JTextField urltextfield) {
		this.webpagetextarea = webpagetextarea;
		this.urltextfield = urltextfield;
	}

	public void actionPerformed(ActionEvent e) {

		// URL som bruker har testet inn i addresse-linjen
		String urlstr = urltextfield.getText();

		// skal lagre tekst som vi leser fra URL
		String text = "";

		/* 
		// konstruer URL objekt
		URL url = new URL(urlstr);

		// få en scanner som kan lese informasjon strøm av tekst fra url'en
		Scanner in = new Scanner(url.openStream());

		// accumulate text received via the URL
		int i = 1;
		while (i <= MyBrowser.MAX_LINES && in.hasNextLine()) {

			String linje = in.nextLine();
			// TODO legg linjen til text

		}

		// legg teksten som er lest fra URL'en inn i hovedvinduet
		webpagetextarea.setText(text);

		in.close();

		// håndter unntak MalformedURLException (Feil format på URL) og
		// IOException (web siden kunne ikke åpnes) ved å skive ut feilmelding
		// bruk setText metoden på webpagetextarea objektet til å sette teksten
		// bruk finally til altid å sette address-linjen til den tomme teksten
*/
	}
}
