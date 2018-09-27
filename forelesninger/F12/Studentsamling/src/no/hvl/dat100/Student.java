package no.hvl.dat100;

import static java.lang.String.format;

public class Student {
	private int studenrNr;
	private String fornavn;
	private String etternavn;
	private int studentNr;

	// Konstruktører

	public Student(int studentNr, String fornavn, String etternavn) {
		this.studentNr = studentNr;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}
	
	public Student() {
		this(0, "", "");
	}

	// Objektmetoder

	public boolean erLik(Student denAndre) { // Beøver ikke get-metode her!
		if (denAndre == null) {
			return false;
		}
		return (this.studentNr == denAndre.studentNr);
	}

	public String studentNrOgnavn() {
		return studentNr + ": " + etternavn + ", " + fornavn;
	}

	public int getStudentNr() {
		return studentNr;
	}

	public void setStudentNr(int studentNr) {
		this.studentNr = studentNr;
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
	public String toString() { // Vil senere sortere 
		String streng = format("%-10d", getStudentNr()) + format("%-15s", etternavn) + format("%-15s", fornavn);
		return streng;
	}

}
