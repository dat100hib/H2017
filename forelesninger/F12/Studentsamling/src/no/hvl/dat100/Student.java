package no.hvl.dat100;

import static java.lang.String.format;

public class Student {
	private int studNr;
	private String fornavn;
	private String etternavn;

	// Metoder

	public Student() {
		this(0, "", "");
	}

	public Student(int studNr, String fornavn, String etternavn) {
		this.studNr = studNr;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}

	// Andre metoder

	public boolean erLik(Student denAndre) { // Beøver ikke get-metode her!
		if (denAndre == null) {
			return false;
		}
		return (this.studNr == denAndre.studNr);
	}

	public String skrivNr() {
		return studNr + ": " + etternavn + ", " + fornavn;
	}

	public int getStudNr() {
		return studNr;
	}

	public void setStudNr(int studNr) {
		this.studNr = studNr;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	@Override
	public String toString() {
		String streng = format("%-10d", studNr) + format("%-15s", etternavn) + format("%-15s", fornavn);
		return streng;
	}

}
