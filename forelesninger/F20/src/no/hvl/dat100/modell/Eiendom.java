package no.hvl.dat100.modell;

import java.util.ArrayList;

/**
 * Basisklasse for representasjon av eiendommer.
 * 
 * @author Lars Kristensen
 * @version 1.0
 */

public abstract class Eiendom {

	private int gns;
	private int bns;

	private ArrayList<Eier> eiere;

	private static int MAX_NABOER = 4;
	private Eiendom[] naboer;

	/**
	 * Konstruer Eiendoms objekt.
	 * 
	 * @param gns
	 *            Gårdsnummer
	 * @param bns
	 *            Bruksnummer
	 */
	public Eiendom(int gns, int bns) {
		this.gns = gns;
		this.bns = bns;
		naboer = new Eiendom[MAX_NABOER];
		eiere = new ArrayList<Eier>();
	}

	/**
	 * Hent gårdsnummer for eiendom.
	 * 
	 * @return Gårdsnummer
	 */
	public int getGns() {
		return gns;
	}

	/**
	 * Hent bruksnummer for eiendom.
	 * 
	 * @return Bruksnummer
	 */
	public int getBns() {
		return bns;
	}

	/**
	 * Register en ny eier på eiendommen (legges til).
	 * 
	 * @param nyeier
	 *            Eier som skal registreres på eiendom
	 */
	public void registrerEier(Eier nyeier) {
		eiere.add(nyeier);
	}

	/**
	 * Registrer en eiendom som nabo.
	 * 
	 * @param naboeiendom
	 *            eiendom som skal registreres som eiendom
	 * @return blev nabo registret (max 4 naboer per eiendom)
	 */
	public boolean registrerNabo(Eiendom naboeiendom) {
		boolean finnes = false;

		// sjekk om nabo eiendom finnes allerede
		for (Eiendom eiendom : naboer) {
			if (eiendom != null) {
				if ((eiendom.bns == naboeiendom.bns) && (eiendom.gns == naboeiendom.gns)) {
					finnes = true;
				}
			}
		}

		// sett inn hvis plass -
		if (!finnes) {

			int i = 0;
			while ((!finnes) && i < MAX_NABOER) {
				if (naboer[i] == null) {
					naboer[i] = naboeiendom;
					finnes = true;
				}
				i++;
			}
		}

		return finnes;
	}

	/**
	 * Hent eiere for eiendommen.
	 * 
	 * @return listen av eiere på eiendommen
	 */
	public ArrayList<Eier> getEiere() {
		return eiere;
	}
}
