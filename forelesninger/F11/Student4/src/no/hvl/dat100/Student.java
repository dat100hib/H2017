package no.hvl.dat100;

public class Student {
	// Konstant
	private static int STOR = 20;
	// Objektvariabler (instansvariabler)

	private int nr;
	private int antFag; // antall fag/karakter avlagt
	private Navn navn;
	private String studium;
	private String[] fag; // antar hvert emnet på 10 studiepoeng
	private char[] karakterer;// parallelle tabeller

	// Konstruktører

	public Student() {
		this(0, 0, null, "");
	}

	public Student(int nr, int antFag, Navn navn, String studium) {
		this.nr = nr;
		this.antFag = antFag;
		this.navn = navn;
		this.studium = studium;
		fag = new String[STOR];
		karakterer = new char[STOR];
	}

	/**
	 * 
	 * @return antall studiepoeng
	 */
	public int studiePoeng() {
		return (3 * antFag);
	}

	/**
	 * 
	 * @return poengsum
	 */

	public int poengsum() {
		int sum = 0;
		int poeng = 0;
		for (int i = 0; i < antFag; i++) {
			char kar = karakterer[i];
			poeng = Utility.karakterTilPoeng(kar);
			sum = sum + poeng;
		}
		return sum;
	}

	/**
	 * 
	 * @return gjennomsnittpoeng
	 */

	public double snittPoeng() {
		return (double) poengsum() / antFag;
	}

	/**
	 * 
	 * @return gjennomsnittkarakter
	 */

	public char snittKarakter() {
		double snitt = snittPoeng();
		char kar = Utility.poengTilKarakter(snitt);
		return kar;
	}

	/**
	 * 
	 * @return
	 */
	public String[] getFag() {
		return fag;
	}

	/**
	 * 
	 * @param fag
	 */

	public void setFag(String[] fag) {
		this.fag = fag;
	}

	/**
	 * 
	 * @return
	 */

	public char[] getKarakterer() {
		return karakterer;
	}

	/**
	 * 
	 * @param karakterer
	 */
	public void setKarakterer(char[] karakterer) {
		this.karakterer = karakterer;
	}

	/**
	 * 
	 * @return
	 */
	public int getAntFag() {
		return antFag;
	}

	/**
	 * 
	 * @param antFag
	 */

	public void setAntFag(int antFag) {
		this.antFag = antFag;
	}

	/**
	 * @Override
	 * 
	 */

	public String toString() {
		String streng = "Studnr " + nr + " " + navn + " " + studium;
		return streng;
	}
}