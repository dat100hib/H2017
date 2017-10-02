package no.hvl.dat100;

public class Student {
	private int studNr;
	private String fornavn;
	private String etternavn;

	// Konstruktører

	public Student() {
		this(0, "", "");

	}

	public Student(int studNr, String fornavn, String etternavn) {
		this.studNr = studNr;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}

	// Andre metoder

	public boolean erLik(Student denAndre) { // Behøver ikke get-metode for
												// denAndre!
		if (denAndre == null) {
			return false;
		}
		return (this.studNr == denAndre.studNr);
	}
	
	//alt:
	

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
		return "Student [studNr:" + studNr + ", fornavn:" + fornavn + ", etternavn:" + etternavn + "]";
	}

}
