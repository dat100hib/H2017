package no.hvl.dat100;

public class Ansatt implements Element {
	private int nr;
	private String fornavn;
	private String etternavn;
	private double loenn;
	
	
	public Ansatt() {
		nr = 0;
		fornavn = "N";
		etternavn = "N";
		loenn = 0.0;
	}

	public Ansatt(int nr, String fn, String en, double loenn) {
		this.nr = nr;
		fornavn = fn;
		etternavn = en;
		this.loenn = loenn;
	}
	
	@Override
	public String nokkel() {
		return Integer.toString(nr);
	}
	public int getNr() {
		return nr;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public double getLoenn() {
		return loenn;
	}

	public void setLoenn(double loenn) {
		this.loenn = loenn;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}
	
	public void setFornavn(String fn) {
		this.fornavn = fn;
	}
	
	public String toString() {
		return nr + " " + fornavn + " " + etternavn + " Lønn: " + loenn;
	}
}

