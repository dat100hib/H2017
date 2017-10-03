package no.hvl.dat100;

import java.util.Arrays;

public class Studentsamling {

	private final static int STDK = 100;
	private int antall;
	private Student[] samling; // alltid usortert

	public static int getStdk() {
		return STDK;
	}


	/*
	 * Konstruktører
	 */
	public Studentsamling(int startKapasitet) {
		samling = new Student[startKapasitet];
		antall = 0;
	}

	public Studentsamling() {
		this(STDK);
	}

	
	/*
	 * Legger student bak i tabellen
	 */
	public void leggTil(Student student) {
		if (antall == samling.length) {
			utvid();
		}
		samling[antall] = student;
		antall++;
	}

	/*
	 * Fjerner og returnerer student hvis fins ellers null
	 */
	public Student fjern(int nr) {
		Student stud = null;
		int indeks = finn(nr);
		if (indeks != -1) {
			stud = samling[indeks];
			samling[indeks] = samling[antall - 1];
			antall--;
		} // if
		return stud;
	}

	/*
	 * Søker og returnerer en student hvis den fins
	 */

	public Student sok(int nr) {
		int indeks = finn(nr);
		if (indeks == -1) {
			return null;
		}else{
			return samling[indeks];
		}
	}

	/*
	 * Finner indeksen til en student med gitt nr hvis den fins
	 */

	private int finn(int nr) {
		int i = 0;
		int resultat = -1;
		boolean funnet = false;
		if (!erTom()) {
			while (!funnet && i < antall) {
				if (nr == (samling[i].getStudNr())) {
					funnet = true;
				} else {
					i++;
				}
			}
			if (funnet) {
				resultat = i;
			}
		}
		return resultat;

	}

	/*
	 * 
	 * Avgjør om samlingen er tom
	 */
	public boolean erTom() {
		return (antall == 0);
	}

	/*
	 * Utvider tabellen ved behov
	 * 
	 */
	private void utvid() {
		Student[] hjelpeTabell = new Student[samling.length * 2];
		for (int i = 0; i < samling.length; i++) {
			hjelpeTabell[i] = samling[i];
		}
		samling = hjelpeTabell;
	}
	

	public Student[] getSamling() {
		return samling;
	}

	public int getAntall() {
		return antall;
	}
	

}// class
