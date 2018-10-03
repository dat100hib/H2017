package no.hvl.dat100.todo;

/*
* Beskriver en Dato-klasse med tre objektvariabler:
* aar, mnd og dag. Klassen har objekmetoder for aar
* sammenligne, skrive ut og teste lovlig oppsett.
* Forenklet oppsett for en dato er aar.mm.dd
*/
import static java.lang.Integer.*;

public class Dato {

	// Aarstallet er 4-sifret, eks. 2018
	private int aar;
	private int mnd;
	private int dag;
	
	public Dato() { // eksplisitt standardkonstruktør
		aar = 1700;
		mnd = 1;
		dag = 1;
	}

	public Dato(int aar, int mnd, int dag) {
		this.aar = aar;
		this.mnd = mnd;
		this.dag = dag;
	}
	
	public Dato(String strDato) { // "10.03.2018"
		//TODO
	}
	

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public int getMnd() {
		return mnd;
	}

	public void setMnd(int mnd) {
		this.mnd = mnd;
	}

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public boolean lik(Dato denAndre) {
		//TODO
		return true;
	}

	public boolean foer(Dato dato) {
		//TODO
		return true;
	}

	public boolean lovlig() {
		// Avgjoer om baade aar, mnd og dag har lovlige verdier
		boolean okAar = (1700 <= aar && aar <= 2099);
		boolean okMnd = (1 <= mnd && mnd <= 12);
		boolean okDag = (1 <= dag && dag <= antallDager(aar, mnd));
		return okAar && okMnd && okDag;
	}

	public String toString() { // lager en streng eks: 2018.09.14
		//TODO
		return null;
	}

	// Hjelpemetoder

	private static int antallDager(int aaret, int maaned) {
		int dager = 31;
		//TODO
		return dager;
	}

	private static boolean skuddAr(int aaret) {
		return ((aaret % 4 == 0 && aaret % 100 != 0) || (aaret % 400 == 0));
	}

}