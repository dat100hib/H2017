package no.hvl.dat100.lagring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collection;
import java.util.Iterator;

import no.hvl.dat100.modell.Eiendom;
import no.hvl.dat100.modell.EiendomsRegister;

public class Lagring {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/lagring/";

	private static String NE = "NERINGSEIENDOM";
	private static String UE = "UTLEIEEIENDOM";

	public static boolean skriv(EiendomsRegister register, String filnavn) {

		boolean skrevet = true;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(MAPPE + filnavn);

			String kommune = register.getKommune();
			
			writer.println(kommune);

			Collection<Eiendom> eiendommer = register.getEiendommer();
			
			writer.println(eiendommer.size());
			
			Iterator<Eiendom> eit = eiendommer.iterator();
			
			while (eit.hasNext()) {
				Eiendom e = eit.next();
				writer.println(e.toString());
			}
			
			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println("Feil ved skriving av register");
			skrevet = false;
		}

		return skrevet;
	}

	private static void lesNaboer(Scanner reader) {
		
	}
	private static Eiendom lesEiendom(Scanner reader) {
		/*
		10 20
		1
		Odd Vanden
		1560
		Fyllingsveien 84
		5120 Fyllingen
		Bahamas
		1 10 10
		*/
		// mangler å skrive typen på eiendom inn i file
		// implemetere toString metoder på de to klasser
		// Eiendom e = new UtleieEiendom();
		
		return null;
	}
	
	public static EiendomsRegister les(String filnavn) {

		EiendomsRegister register = null;

		try {

			File file = new File(MAPPE + filnavn);
			Scanner reader = new Scanner(file);

			String kommune = reader.nextLine();
			register = new EiendomsRegister(kommune);
			
			int antall = Integer.parseInt(reader.nextLine());
			
			for (int i = 1; i<=antall;i++) {
				Eiendom e = lesEiendom(reader);
			}
/*
			samling = new PersonSamling(antall);
			Person person = null;

			while (reader.hasNextLine()) {
				line = reader.nextLine();

				long fodselsnummer = Long.parseLong(reader.nextLine());
				String etternamn = reader.nextLine();
				String fornamn = reader.nextLine();

				if (line.equals(STUDENT)) {
					int studentnummer = Integer.parseInt(reader.nextLine());
					String klasse = reader.nextLine();
					person = new Student(etternamn, fornamn, fodselsnummer, studentnummer, klasse);
				} else if (line.equals(LAERER)) {
					int lonn = Integer.parseInt(reader.nextLine());
					int kontonummer = Integer.parseInt(reader.nextLine());
					person = new Laerer(etternamn, fornamn, fodselsnummer, lonn, kontonummer);
				} else {
					System.out.println("Feil i filformat");
				}

				samling.leggTil(person);
			}
*/
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Feil i filformat");
		}
		return register;
	}
}
