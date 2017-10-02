package no.hvl.dat100;

public class Student {
	private int studNr;
	private String fornavn;
	private String etternavn;

	public Student() {
		studNr = 0;
		fornavn = null;
		etternavn = null;		
	}
	
	public Student(int studNrInit, String fornavnInit, String etternavnInit) {
		studNr = studNrInit;
		fornavn = fornavnInit;
		etternavn = etternavnInit;
	}

	public int getStudNr() {
		return studNr;
	}

	public void setStudNr(int nyStudNr) {
		studNr = nyStudNr;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String nyFornavn) {
		fornavn = nyFornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String nyEtternavn) {
		etternavn = nyEtternavn;
	}

	@Override
	public String toString() {
		return "Student [studNr:" + studNr + ", fornavn:" + fornavn + ", etternavn:" + etternavn + "]";
	}
}
