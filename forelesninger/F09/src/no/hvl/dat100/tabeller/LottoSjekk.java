package no.hvl.dat100.tabeller;

public class LottoSjekk {

	public static int ANTALL = 7;
	
	static int[] lottoTall = {34,2,7,16,21,29,1};
	
	static int[] minKupong1 = {12,1,34,16,2,25,26};
	static int[] minKupong2 = {2,7,34,16,21,1,29};
	
	public static boolean sjekkkupong_v1(int[] kupong, int[] lottotall) {
		return (lottotall == kupong); 
	}
	
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
	
	public static boolean sjekkkupong_v2(int[] kupong, int[] lottotall) {
		
		for (int i = 0; i<ANTALL; i++) {
			int tall = lottotall[i];
			
			boolean hartall = finnesTall(tall,kupong);
			
			if (!hartall) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(sjekkkupong_v1(minKupong1,lottoTall));
		System.out.println(sjekkkupong_v1(minKupong2,lottoTall));
		
		System.out.println(sjekkkupong_v2(minKupong1,lottoTall));
		System.out.println(sjekkkupong_v2(minKupong2,lottoTall));
	}
}
