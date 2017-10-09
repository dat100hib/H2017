package no.hvl.dat100;

//Importerer aktuelle filklasser
import java.io.*;


public class SkrivNavneliste {

	public static void main(String[] args) throws Exception {
		// Åpner filen for skriving
		String filnavn = "navn.txt";
		PrintWriter skriver = new PrintWriter(filnavn);

		String[] navnTab = { "Ole", "Kari", "Jan", "June", "Jenny", "Fredrik" };

		// Skriv hvert navn i navnTab til fil
		for (int i = 0; i < navnTab.length; i++)
			skriver.println(navnTab[i]);

		skriver.close(); // Lukker filen
	}

}
