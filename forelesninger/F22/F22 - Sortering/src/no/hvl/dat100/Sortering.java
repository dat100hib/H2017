package no.hvl.dat100;

public class Sortering {
	
	public static void plukkSortering(int[] tab) {
		
		int n = tab.length;
		
		for (int i = 0; i < n - 1; i++) {
			int minPos = i;
			for (int j = i + 1; j < n; j++) {
				if (tab[j] < tab[minPos]) {
					minPos = j;
				}
			}
			
			int tmp = tab[i];
			tab[i] = tab[minPos];
			tab[minPos] = tmp;
		}
	}

	public static void main(String[] args) {
		
		int[] tabell = {0, 8, 4, 6, 2, 1};
		
		plukkSortering(tabell);
		
		for (int e : tabell) {
			System.out.print(e + " ");
		}
		System.out.println();;
	}

}
