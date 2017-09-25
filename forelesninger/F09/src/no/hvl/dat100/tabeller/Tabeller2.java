package no.hvl.dat100.tabeller;

public class Tabeller2 {

	// vanlig for-løkke - og tabeller som parameter og returverdi
	public static int[] kopier(int[] tabell) {
		
		int[] kopi = new int[tabell.length];
		
		for (int pos = 0;pos<tabell.length;pos++) {
			kopi[pos] = tabell[pos];
		}
		
		return kopi;
	}
	
	// utvidet for-løkke tabeller - tabell som parameter
	public static void skrivUt(int[] tabell) {
		System.out.print("[ ");
		
		for (int tall : tabell) {
			System.out.print(tall + " ");
		}
		
		System.out.println("]");
	}
	
	// tabeller som parametre - referanse overførsel
	public static void oppdater(int[] tabell, int v,int pos) {
		tabell[pos] = v;
	}
	
	// while-løkke - typisk ifm. søkning
	public static boolean finnesTall(int tall, int[] tabell) {
		boolean funnet = false;
		int pos = 0;
		
		while (!funnet && pos < tabell.length) {
			if (tall == tabell[pos]) {
				funnet = true;
			}
			pos++;
		}
		
		return funnet;
	}
	
	public static void main(String[] args) {
 
		int[] itab = {7,17,20,4,8,12};
				
		// tabellvariabel er en referanse til en tabell
		System.out.println(itab);
		skrivUt(itab);
		
		// oppdatering av en tabell 
		oppdater(itab,19,2);
		skrivUt(itab);
		
		// kopiering av en tabell
		int[] tab = kopier(itab);
		skrivUt(tab);
		System.out.println(tab);
	}

}
