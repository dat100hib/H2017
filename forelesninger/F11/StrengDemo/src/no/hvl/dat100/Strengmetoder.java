package no.hvl.dat100;

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import java.util.Arrays;
import static java.lang.String.format;

public class Strengmetoder {

	public static void test1() {
		String s1 = "abc";
		String s2 = s1;
		s1 = s1.replace('b', 'x');
		System.out.print("s1=" + s1 + " s2=" + s2);
		System.out.println();
	}

	public static void test2() {
		String tekst = "Et ord, men ikke mer.";
		String regex = "(\\.|,| |\n)+";
		String[] ordTab = tekst.split(regex);
		int antallTegn = 0;

		for (int i = 0; i < ordTab.length; i++) {
			String ord = ordTab[i];
			antallTegn += ord.length();
			out.println(ord + ": " + ord.length());
		}

		int snitt = antallTegn / ordTab.length;
		out.print("Gj.snittlig ordlengde: " + snitt);
		out.println();
	}

	public static void test3() {
		String s = "Her er en tekst. Den har flere ord " + "med blanke, punktum, komma og et \n"
				+ "linjeskift som skilletegn.";
		String[] ordTab = s.split("(\\.|,| |\n)+");
		String moenster = "nk";
		int antallOrd = 0;

		for (int i = 0; i < ordTab.length; i++) {
			String ord = ordTab[i];
			int pos = ord.indexOf(moenster);
			System.out.print(ord);
			if (pos >= 0) {
				antallOrd++;
				System.out.print(" ==> " + moenster + " i pos " + pos);
			}
			System.out.println();
		}
		System.out.print("Antall treff: " + antallOrd);
		System.out.println();
	}

	public static void test4() {
		String tekst = "Et tall, og et tall.";
		tekst = tekst.toLowerCase();

		String regex = "(\\.|,| |\n)+";
		String[] ordTab = tekst.split(regex);

		Arrays.sort(ordTab);

		String[] ordListe = new String[ordTab.length];
		int antNyeOrd = 0;

		for (int i = 0; i < ordTab.length; i++) {
			String ord = ordTab[i].toUpperCase();

			boolean funnet = false;
			int j = 0;
			while (!funnet && j < antNyeOrd)
				if (ord.equals(ordListe[j]))
					funnet = true;
				else
					j++; // let videre...

			if (!funnet) {
				ordListe[j] = ord;
				antNyeOrd++;
				out.println(ord);
			}
		}
	}

	public static void test5() {
		System.out.println("NÃ¥ er det metode 5");
		String tekst = "Et tall, og et tall.";
		String regex = "(\\.|,| |\n)+";
		String[] ordTab = tekst.split(regex);

		Arrays.sort(ordTab);

		String[] ordListe = new String[ordTab.length];
		int antNyeOrd = 0;
		Arrays.fill(ordListe, ordTab[0]);
		for (int i = 1; i < ordTab.length; i++) {
			String ord = ordTab[i].toUpperCase();
			if (Arrays.binarySearch(ordListe, ord) < 0) {
				ordListe[antNyeOrd] = ord;
				antNyeOrd++;
				System.out.println(ord);
			}
		}
	}

	public static void test6() {
		//Særnorske bokstaver har fått tallkoder som bryter med alfabetisk ordning
		
		System.out.println("Naa er det metode 6");
		//String tekst = "Øistein øker, Ågot ånder, Bjarne bor, Æsop æser.";
		String tekst = "Lars vokser, Reidun fisker, Bjarne stuper, Maja studerer";
		String regex = "(\\.|,| |\n)+";
		String[] ordTab = tekst.split(regex);
		String svar = tekst + "\n";
		Arrays.sort(ordTab);
		int antallTegn = 0;
		for (int i = 0; i < ordTab.length; i++) {
			String ord = ordTab[i];
			antallTegn += ord.length();
			System.out.println(ord.toUpperCase() + ": " + ord.length());
			svar += ord.toUpperCase() + ": " + ord.length() + "\n";
		}
		double snitt = (double) antallTegn / ordTab.length;
		System.out.print("Gj.snittlig ordlengde: " + format("%8.2f", snitt));
		System.out.println();
		svar += "Gj.snittlig ordlengde: " + format("%8.2f", snitt);
		showMessageDialog(null, svar);
	}

}