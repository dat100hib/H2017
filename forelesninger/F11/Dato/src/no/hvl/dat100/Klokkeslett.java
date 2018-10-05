package no.hvl.dat100;

/*
* Beskriver en  Klokkeslett-klasse med objektvariabler
* for timer og minutter. Klassen har objekmetoder for å sammenligne,
* skrive ut og teste lovlige klokkeslett.
* Utskrift for et klokkeslett  tt:mm
*/
import static java.lang.Integer.*;

public class Klokkeslett {

	private int timer;
	private int minutter;
	//kan utvide med sekunder senere
	
	public Klokkeslett () {
		timer = 0;
		minutter = 0;
	}

	public Klokkeslett(int timer, int minutter) {
		this.timer = timer;
		this.minutter = minutter;
	}

	public Klokkeslett(String strKlSlett) { //"time:min"
		String[] tidTab = strKlSlett.split(":");
		timer = parseInt(tidTab[0]);
		minutter = parseInt(tidTab[1]);
	}

	public boolean erLik(Klokkeslett annenKlslett) {
		// Avgjør om de to klokkeslettene er like
		// dette(this) og parameteren
		String denneTid = this.toString();
		String annenTid = annenKlslett.toString();
		return denneTid.equals(annenTid); // equals i Stringklassen
	}

	public boolean foer(Klokkeslett annenKlslett) {
		// Avgjør hvilket av to klokkesletter kommer først,
		// dette (this) eller parameteren
		int denneTid = timer * 60 + minutter;
		int annenTid = annenKlslett.timer * 60 + annenKlslett.minutter;
		return (denneTid < annenTid);
	}

	public boolean lovlig() {
		boolean okTim = (0 <= timer && timer < 24);
		boolean okMin = (0 <= minutter && minutter < 60);
		return (okTim && okMin);
	}

	public String toString() {
		// For også å kunne skrive 09:05
		String ut = "";
		if (timer < 10) {
			ut = ut + "0";
		}
		ut = ut + timer + ":";
		if (minutter < 10) {
			ut = ut + "0";
		}
		ut = ut + minutter;
		return ut;
	}
}