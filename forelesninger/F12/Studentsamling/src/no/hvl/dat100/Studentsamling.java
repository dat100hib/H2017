package no.hvl.dat100;

import java.util.Arrays;

public class Studentsamling {

	private final static int STDK = 100;
	private int antall;
	private Student[] samling; // usortert

	/*
	 * Konstruktører
	 */
	
	public Studentsamling() {
		this(STDK);
	}
	public Studentsamling(int startKapasitet) {
		samling = new Student[startKapasitet];
		antall = 0;
	}

	/*
	 * Objektmetdoer
	 */
	
	/*
	 * Legger student bak i tabellen
	 */
	public void leggTil(Student student) {//TODO
		
	}

	/*
	 * Fjerner og returnerer student hvis fins ellers null
	 */
	public Student fjern(int nr) {//TODO
		Student stud = null;
		
		return stud;
	}

	/*
	 * Søker og returnerer en student hvis den fins
	 */

	public Student sok(int nr) {
		return null;//TODO
		
	}

	/*
	 * Finner indeksen til en student med gitt nr hvis den fins
	 */

	private int finn(int nr) {//TODO
		int i = 0;
		int resultat = -1;
		
		return resultat;

	}

	/*
	 * 
	 * Avgjør om samlingen er tom
	 */
	public boolean erTom() {
		return (antall == 0);
	}

	
	public Student[] getSamling() {
		return samling;
	}

	public int getAntall() {
		return antall;
	}
	

}// class
