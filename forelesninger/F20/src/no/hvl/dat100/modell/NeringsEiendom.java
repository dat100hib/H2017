package no.hvl.dat100.modell;


/**
 * Klasse for representasjon av næringseiendommer.
 * @author Lars Kristensen
 * @version 1.0
 */

public class NeringsEiendom extends Eiendom {

	private int orgnr;
	
	/**
	 * Konstruer næringseiendomsobjekt.
	 * @param gns Gårdsnummer
	 * @param bns Bruksnummer
	 * @param orgnr Organisasjonsnummer
	 */
	public NeringsEiendom(int gns, int bns,int orgnr) {
		super(gns, bns);
		this.orgnr = orgnr;	
	}

	/**
	 * Hent organisasjonsnummer.
	 * @return organisasjonsnummer
	 */
	public int getOrgnr() {
		return orgnr;
	}
}
