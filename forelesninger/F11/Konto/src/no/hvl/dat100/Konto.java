
 
package no.hvl.dat100;

/**
 
 *
 */
public class Konto {
	private  static int nummer = 0;
	private String eier;
	private String adresse;
	private int kontonummer;
	private int saldo;

	//Konstruktører
	public Konto(String eier,String adresse, int saldo) {
		this.eier = eier;
		this.adresse = adresse;
		this.saldo = saldo;
		bestemKontonummer();
		
	}
	
	public Konto(){
		this("","",0);
	}

	//Andre metoder
	
	public void bestemKontonummer() {
		nummer++;
		kontonummer = nummer;
	}
		
	public boolean taUt(int uttak) {
			if (uttak > saldo){
				return false;
			}
			saldo = saldo - uttak;
			return true;
		}

	public boolean overforTilAnnenKonto(Konto tilKonto, int belop) {
		if (taUt(belop)) {
			tilKonto.settInn(belop);
			return true;
		} else {
			return false;
		}
	}

	public void skrivTilstand() {
		System.out.print("Eier: " + eier);
		System.out.print("\tAdresse: " + adresse);
		System.out.print("\t Kontonummer: " + kontonummer);
		System.out.print("\t Saldo: " + saldo);
		System.out.println();
	}
	
	public static int getNummer() {
		return nummer;
	}
	
    /* Bør utgå i denne problemstillingen
	public static void setNummer(int nummer) {
		Konto.nummer = nummer;
	}
     */
	
	public String getEier() {
		return eier;
	}

	public void setEier(String eier) {
		this.eier = eier;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getKontonummer() {
		return kontonummer;
	}
	
	// setKontonummer() bør utgå i denne problemmestillingen
	
	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void settInn(int innskudd) {
		saldo = saldo + innskudd;
	}
		

}// class
