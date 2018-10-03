package no.hvl.dat100.todo;

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
		//TODO
	}

	public Klokkeslett(String strKlSlett) { //"time:min"
		//TODO
	}

	public boolean erLik(Klokkeslett annenKlslett) {
		//TODO
		return true;
	}

	public boolean foer(Klokkeslett annenKlslett) {
		//TODO
		return true;
	}

	public boolean lovlig() {
		//TODO
		return true;
	}

	public String toString() {
		//TODO
		return null;
	}
}