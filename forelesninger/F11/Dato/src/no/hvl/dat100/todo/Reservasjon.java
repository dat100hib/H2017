package no.hvl.dat100.todo;

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

	public Reservasjon(Dato dato, Klokkeslett startTid, 
			Klokkeslett sluttTid, String kontakt) {
		
		//TODO
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
		//TODO
		return ledig;
	}

	public String toString() {
		return dato.toString() + ", " + startTid.toString() + " - " + sluttTid.toString() + ".  Ref. " + kontakt;
	}

}
