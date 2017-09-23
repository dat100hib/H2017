package no.hvl.dat100.tabeller;

public class Tabeller2 {
	
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
	
	public static void main(String[] args) {

		boolean[] btab = {true,false,true,false,false,true};
				
		// tabellvariabel er en referanse til en tabell
		System.out.println(btab);

		// oppdatering av en tabell 
		System.out.print("Tabell før oppdatering   : ");
		skrivUt(btab);
		
		oppdater(btab,true,1);
		
		System.out.print("Tabell etter oppdatering : ");
		skrivUt(btab);
		
		// kopiering av en tabell
		boolean[] tab = kopier(btab);
				
		System.out.print("Innhold kopiert tabell   : ");

		skrivUt(tab);
		
		System.out.println("Reference opprindelig tabell: " + btab);
		System.out.println("Reference kopi av tabell    : " + tab);
	}
	

}
