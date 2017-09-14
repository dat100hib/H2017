
public class Oddetal {
	/* Metode som gitt ein tabell av heiltal som parameter,
	 * returnerer ein tabell som inneheld oddetala i same
	 * rekkefølge tabellen gitt som parameter.
	 */
	public static int[] finnOddetal(int[] tab) {
		int ant = 0;
		for (int tal : tab) {
			if (tal % 2 == 1) {
				ant++;
			}
		}

		int[] oddetab = new int[ant];

		int i = 0;
		for (int tal : tab) {
			if (tal % 2 == 1) {
				oddetab[i] = tal;
				i++;
			}
		}

		return oddetab;
	}

	/* Metode som sjekkar om ein tabell med flyttal er sortert stigande (ikkje minkande)
	 * Metoden returner true om den er sortert, false elles
	 */
	public static boolean erSortert(double[] tab) {
		for (int i = 1; i < tab.length; i++) {
			if (tab[i] < tab[i - 1]) {
				return false;
			}
		}

		return true;

		/*
		 * Alternativ 
		 * for (int i = 0; i < tab.length - 1; i++){ 
		 *    if (tab[i] > tab[i + 1]){ 
		 *       return false; 
		 *    } 
		 * }
		 */

	}

	public static void main(String[] args) {
		double[] a = {3, 4.0, 7.5};
		double[] b = {3, 2.0, 7.5};

		System.out.println(erSortert(a));
		System.out.println(erSortert(b));
		
		int[] c = {7, 6, 3, 2, 1};
		int[] otab = finnOddetal (c);
		
		for (int p : otab) {
			System.out.print(p + " ");
		}
	}

}
