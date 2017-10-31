package no.hvl.dat100;

// Berre testklasse for å vise at vi kan bruke Objektsamling for ulike objekttyper

public class Bok  implements Element{
	private String tittel;
	
	public Bok(String t)  {
		tittel = t;
	}
	
	public String nokkel() {
		return tittel;
	}
	
	@Override
	public String toString() {
		return tittel;
	}
}
