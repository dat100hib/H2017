package no.hvl.dat100.tabeller;

public class LottoSjekk {

	public static int ANTALL = 7;
	
	static int[] lottoTall = {34,2,7,16,21,29,1};
	
	static int[] minKupong1 = {12,1,34,16,2,25,26};
	
	static int[] minKupong2 = {2,7,34,16,21,1,29};
	
	public static boolean sjekkkupong_v1(int[] kupong) {
		return (lottoTall == kupong); 
	}
	
	// TODO: definere en søk metode?
	public static boolean sjekkkupong_v2(int[] kupong) {
		
		for (int i = 0; i<ANTALL; i++) {
			int tall = kupong[i];
			
			boolean funnet = false;
			int j = 0;
			while (!funnet && j<ANTALL) {
				funnet = (tall == lottoTall[j]);
				j++;
			}
			
			if (!funnet) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(sjekkkupong_v1(minKupong1));
		System.out.println(sjekkkupong_v1(minKupong2));
		
		System.out.println(sjekkkupong_v2(minKupong1));
		System.out.println(sjekkkupong_v2(minKupong2));
	}
}
