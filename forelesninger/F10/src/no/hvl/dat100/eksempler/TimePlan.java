package no.hvl.dat100.eksempler;

public class TimePlan {

	// datatype[][] tabellnavn = new datatype[M][N];
	static boolean[][] btab = new boolean[4][5];
	
	// datatype[][] tabellnavn;
	static String[][] timeplan = {
			{"nor","eng","mat","nor","eng"},
			{"gym","ofa","fri","ofa","kun"},
			{"ofa","ofa","gym","mus","kun"},
			{"mat","nor","gym","mus","mat"}
	};
	
	static void skrivTimeplan() {
		
		System.out.println("       man tir ons tor fre");
		System.out.println("--------------------------");
		
		for (int t = 0;t<timeplan.length;t++) {
			
			String[] time = timeplan[t];
	
			System.out.print(t + ".time ");
			
			for (int d = 0;d<time.length;d++) {
				
				System.out.print(time[d] + " ");
			}
			
			System.out.println();
		}
	}
	
	public static void main (String[] args) {
		skrivTimeplan();
		
		// variable = tabellnavn[r][k]
		boolean b = btab[1][3];
		
		// tabellnavn[r][k] = verdi
		btab[1][3] = true;
	}
}
