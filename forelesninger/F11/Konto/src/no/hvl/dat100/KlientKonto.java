package no.hvl.dat100;
public class KlientKonto {
  public static void main(String[] args) {
   
	int innskudd = 500;
	
	Konto k1 = new Konto("Ole Olsen", "Torget 1",0);
    Konto k2 = new Konto("Kari Ludt", "Strandgt 10",0);
    
    k1.settInn(innskudd);
  
    System.out.println("A: Min saldo er = " + k1.getSaldo());

    k1.settInn(1000);
    System.out.println("B: Min saldo er = " + k1.getSaldo());

    k1.settInn(500);
    System.out.println("C: Min saldo er = " + k1.getSaldo());
    
    boolean overfort = k1.overforTilAnnenKonto(k2, 1000);
    if(overfort){
        System.out.println("Overført fra kontonummer " + k1.getKontonummer() + " til kontonummer " + k2.getKontonummer());
    }
    else{
        System.out.println("Ble ikke overført");
    }
    k1.skrivTilstand();
    k2.skrivTilstand();
  }
}

