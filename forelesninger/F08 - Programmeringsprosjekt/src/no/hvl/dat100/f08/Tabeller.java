package no.hvl.dat100.f08;

public class Tabeller {

	public static void skrivUt1(double[] tabell) {

		// vanlig for-løkke
		for (int i = 0; i<tabell.length; i++) {
			
			// indeksering
			double x = tabell[i];
			System.out.println("Indeks: " + i + " inneholder " + x);
		}
			
	}
	
	public static void skrivUt2(double[] tabell) {
		
		System.out.print("[ ");
		
		for (double t : tabell) {
			System.out.print(t + " ");
		}
		
		System.out.println("]");
	}
	
	public static double[] beregnTid(double[] tabell) {
			
		int antall = tabell.length-1;
		double[] tidstabell = new double[antall];
		
		for (int i = 0; i<antall; i++) {
			
			double tid = tabell[i+1] - tabell[i];
			tidstabell[i] = tid;
			
		}
		
		return tidstabell;	
	}
	
	public static boolean bruktMer(double[] tidstabell,double grense) {
		
		boolean funnet = false;
		
		int i = 0;
		while (!funnet && i<tidstabell.length) {
			
			if (tidstabell[i] > grense) {
				funnet = true;
			}
			
			i++;
		}
		
		return funnet;
	}
	
	public static void main(String[] args) {
		
		// initialisering
		// datatype[] tabellnavn = {v1,v2,... , vN}		
		double[] obs = {1.0, 3.0, 4.0, 7.0, 9.0, 10.0};
		double[] tider;
		
		// parameter overførsel tabeller
		skrivUt1(obs);
		
		skrivUt2(obs);
		
		tider = beregnTid(obs);
		skrivUt2(tider);
		
		System.out.println(bruktMer(tider,2.0));
		System.out.println(bruktMer(tider,5.0));
		
	}

}
