package no.hvl.dat100;

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
/*
	public Dato() { //Innføring av den gregorianske kalenderen
		this(1700, 1, 1);
	}
	*/
	public Dato(String strDato) { // "10.03.2018"
		String[] datoTab = strDato.split("\\."); //
		// Her maa vi tegne for forstaa hva som skjer
		// https://docs.oracle.com/javase/10/docs/api/java/lang/String.html
		// Merk spesielt skilletegn for punktum (se s.225 i boken)
		
		dag = parseInt(datoTab[0]);
		mnd = parseInt(datoTab[1]);
		aar = parseInt(datoTab[2]);
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
		return (aar == denAndre.aar && mnd == denAndre.mnd && dag == denAndre.dag);
	}

	public boolean foer(Dato dato) {
		// Avgjoer om denne datoen er før den andre datoen

		String denneDato = toString();
		String annenDato = dato.toString();
		//https://www.tutorialspoint.com/java/java_string_compareto.htm			
		return (denneDato.compareTo(annenDato) < 0);
	}

	public boolean lovlig() {
		// Avgjoer om baade aar, mnd og dag har lovlige verdier
		boolean okAar = (1700 <= aar && aar <= 2099);
		boolean okMnd = (1 <= mnd && mnd <= 12);
		boolean okDag = (1 <= dag && dag <= antallDager(aar, mnd));
		return okAar && okMnd && okDag;
	}

	public String toString() { // lager en streng eks: 2018.09.14
		String streng = aar + ".";
		if (mnd < 10) {
			streng = streng + "0";
		}
		streng = streng + mnd + ".";
		if (dag < 10) {
			streng = streng + "0";
		}
		streng = streng + dag;
		return streng;
	}

	// Hjelpemetode

	private static int antallDager(int aaret, int maaned) {
		int dager = 31;
		if (maaned == 4 || maaned == 6 || maaned == 9 || maaned == 11) {
			dager = 30;
		} else if (maaned == 2) {   // Februar
			if (skuddAr(aaret)) {   // Kall
				dager = 29;        // Skuddaar
			} else {
				dager = 28;
			}
		}
		return dager;
	}

	private static boolean skuddAr(int aaret) {
		return ((aaret % 4 == 0 && aaret % 100 != 0) || (aaret % 400 == 0));
	}

}