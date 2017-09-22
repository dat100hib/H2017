package no.hvl.dat100.tabeller;

public class Tabeller {

	public static void main(String[] args) {

		// deklarering av en tabell
		// datatype[] tabellnavn
		int[] itab; 
		
		// opprette tabell - implisitt initialisering (standardverdi)
		// datatype[] tabellnavn = new datatype[lengde]
		char[] ctab = new char[4]; 
		
		// opprette tabell - eksplitt initialisering
		// datatype[] tabellnavn = {v1,v2,....,vn}
		boolean[] btab = {true,false,true,false,false,true};
				
		// avlese en posisjon i tabell
	    // datatype variabel = tabellnavn[posisjon]
		char c = ctab[1];
		
		// endre innholdet på en posisjon
		// tabellnavn[posisjon] = verdi
		btab[1] = false;
		
		// gjennomløp med for-løkke 
		for (int i = 0; i<btab.length;i++) {
			System.out.print(btab[i]);
		}
		
		System.out.println();
		
		// gjennomløp utvidet for-løkke
		for (boolean b : btab) {
			System.out.print(b);
		}
		
		System.out.println();
		
		// gjennomløp med while-løkke - typisk ifm. søking i tabell
		boolean funnet = false;
		int i = 0;
		while (i<btab.length && !funnet) {
			if (btab[i]) {
				funnet = true;
			}
			i++;
		}
		
		System.out.println("funnet: " + funnet);
		
		// tabellvariabel er en referanse til en tabell
		System.out.println(btab);

		// oppdatering av en tabell 
		skrivUt(btab);
		
		oppdater(btab,true,1);
		
		skrivUt(btab);
		
		// kopiering av en tabell
		boolean[] tab = kopier(btab);
				
		skrivUt(tab);
		
		System.out.println(btab);
		System.out.println(tab);

	}
	
	// tabeller som parametre
	public static void skrivUt(boolean[] tab) {
		System.out.print("[ ");
		for (boolean b : tab) {
			System.out.print(b + " ");
		}
		System.out.println("]");
	}
	
	// tabeller som parametre - referanse overførsel
	public static void oppdater(boolean[] tab, boolean b,int i) {
		tab[i] = b;
	}
	
	// tabeller som returverdi
	public static boolean[] kopier(boolean[] tab) {
		
		boolean[] kopi = new boolean[tab.length];
		
		for (int i = 0;i<tab.length;i++) {
			kopi[i] = tab[i];
		}
		
		return kopi;
	}
}
