package no.hvl.dat100.lagring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

import no.hvl.dat100.modell.*;

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

	private static void lesNaboer(EiendomsRegister register, int antall, Scanner reader) {

		for (int k = 1; k <= antall; k++) {

			String type = reader.nextLine();
			int gns = reader.nextInt();
			int bns = reader.nextInt();

			reader.nextLine();
			Eiendom eiendom = register.finnEiendom(gns, bns);

			int antalleiere = reader.nextInt();
			reader.nextLine();

			for (int i = 1; i <= antalleiere; i++) {
				for (int j = 1; j <= 5; j++) {
					String str = reader.nextLine(); // skip eiere
					System.out.println(str);
				}
			}

			int antallnaboer = reader.nextInt();

			for (int i = 1; i <= antallnaboer; i++) {
				int nabogns = reader.nextInt();
				int nabobns = reader.nextInt();
				Eiendom nabo = register.finnEiendom(nabogns, nabobns);
				eiendom.registrerNabo(nabo);
				reader.nextLine();
			}

			if (type.equals("UTLEIEEIENDOM")) {
				reader.nextLine();
				reader.nextLine();
			} else if (type.equals("NERINGSEIENDOM")) {
				reader.nextLine();

			} else {
				System.out.println("Feil i eiendomstype");
			}
		}
	}

	private static Eier lesEier(Scanner reader) {

		reader.nextLine();
		String navn = reader.nextLine();
		int fodselsnummer = reader.nextInt();

		String vei = reader.next();
		int nummer = reader.nextInt();

		int postnummer = reader.nextInt();
		String by = reader.next();
		
		reader.nextLine();

		String land = reader.nextLine();

		KontaktAdresse ka = new KontaktAdresse(vei, nummer, postnummer, by, land);

		Eier eier = new Eier(navn, fodselsnummer, ka);

		return eier;
		/*
		 * Odd Vanden 1560 Fyllingsveien 84 5120 Fyllingen Bahamas
		 */
	}

	private static Eiendom lesEiendom(Scanner reader) {

		Eiendom eiendom = null;

		String type = reader.nextLine();
		int gns = reader.nextInt();
		int bns = reader.nextInt();

		int antalleiere = reader.nextInt();

		ArrayList<Eier> eiere = new ArrayList<Eier>();

		for (int i = 1; i <= antalleiere; i++) {
			Eier eier = lesEier(reader);
			eiere.add(eier);
		}

		// spring over naboer i første pass
		reader.nextLine();

		if (type.equals("UTLEIEEIENDOM")) {
			int leierfodselsnummer = reader.nextInt();
			int leie = reader.nextInt();
			reader.nextLine();
			eiendom = new UtleieEiendom(gns, bns, leierfodselsnummer, leie);
			eiendom.setEiere(eiere);
		} else if (type.equals("NERINGSEIENDOM")) {
			int orgnr = reader.nextInt();
			reader.nextLine();
			eiendom = new NeringsEiendom(gns, bns, orgnr);
			eiendom.setEiere(eiere);
		} else {
			System.out.println("Feil i eiendomstype");
		}

		/*
		 * UTLEIEEIENDOM 10 20 1 Odd Vanden 1560 Fyllingsveien 84 5120 Fyllingen
		 * Bahamas 1 10 10 1096 10000 NERINGSEIENDOM 10 10 1 Bente Rask 1741
		 * Nymarksveien 42 5020 Bergen Norge 1 10 20 202020
		 */

		return eiendom;
	}

	public static EiendomsRegister les(String filnavn) {

		EiendomsRegister register = null;

		try {

			File file = new File(MAPPE + filnavn);
			Scanner reader = new Scanner(file);

			String kommune = reader.nextLine();
			register = new EiendomsRegister(kommune);

			int antall = Integer.parseInt(reader.nextLine());

			for (int i = 1; i <= antall; i++) {
				Eiendom e = lesEiendom(reader);
				register.registrerEiendom(e);
			}

			reader.close();

			file = new File(MAPPE + filnavn);
			reader = new Scanner(file);

			reader.nextLine(); // kommune
			reader.nextLine(); // antall

			lesNaboer(register, antall, reader);

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Feil i filformat");
		}
		return register;
	}
}
