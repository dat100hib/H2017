package no.hvl.dat100;

/*
 * Beskriver en Reservasjon-klasse med objektvariablene:
 * kontakt, dato, start og slutt. Programmet skal kun ta
 * ta seg av reservasjoner for ett bestemt rom.
 */
import static java.lang.Integer.*;

public class Reservasjon {

	private Dato dato;
	private Klokkeslett startTid;
	private Klokkeslett sluttTid;
	private String kontakt;

	public Reservasjon(Dato dato, Klokkeslett startTid, Klokkeslett sluttTid, String kontakt) {
		this.dato = dato;
		this.startTid = startTid;
		this.sluttTid = sluttTid;
		this.kontakt = kontakt;
	}

	// get-og set-metoder

	public Dato getDato() {
		return dato;
	}

	public void setDato(Dato dato) {
		this.dato = dato;
	}

	public Klokkeslett getStart() {
		return startTid;
	}

	public void setStart(Klokkeslett startTid) {
		this.startTid = startTid;
	}

	public Klokkeslett getSlutt() {
		return sluttTid;
	}

	public void setSlutt(Klokkeslett sluttTid) {
		this.sluttTid = sluttTid;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public boolean kollisjonMed(Reservasjon r) {
		boolean ledig = true;
		if (dato.lik(r.dato)) {
			ledig = (sluttTid.foer(r.startTid) || sluttTid.erLik(r.startTid) || r.sluttTid.foer(startTid) || r.sluttTid.erLik(startTid));

		}
		return ledig;
	}

	public String toString() {
		return dato.toString() + ", " + startTid.toString() + " - " + sluttTid.toString() + ".  Ref. " + kontakt;
	}

}
