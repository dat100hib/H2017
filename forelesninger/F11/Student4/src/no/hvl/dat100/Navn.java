package no.hvl.dat100;

/*
 * Beskriver en klasse Navn med to objektvariabler:
 * fornavn og etternavn. Det er brukt innkapsling,
 * og da trengs det set- og get-metoder. En egen
 * metode for aa sikre stor foerstebokstav.
 */

public class Navn {

	// Objektvariabler
	private String fornavn;
	private String etternavn;

	// Konstruktører
	
	public Navn(){
		fornavn = "";
		etternavn = "";
	}
	
	public Navn(String startFornavn, String startEtternavn) {
		fornavn = korriger(startFornavn);
		etternavn = korriger(startEtternavn);
	}
	
	// Objektmetoder
	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setFornavn(String nyFornavn) {
		fornavn = korriger(nyFornavn);
	}

	public void setEtternavn(String nyEtternavn) {
		etternavn = korriger(nyEtternavn);
	}

	public String toString() {
		return etternavn + ", " + fornavn;
	}

	private String korriger(String navn) {
		navn = navn.toLowerCase();
		char forbokstav = navn.charAt(0);
		navn = Character.toUpperCase(forbokstav) + navn.substring(1);
		return navn;
	}

}