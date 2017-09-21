package no.hvl.dat100.eksempler;

public class Temperatur {

	static final int ANT_OBS = 3;
	static final int ANT_DAG = 7;

	static int[][] temp = {
			{12,10,10,12,16,16,15},
			{18,12,17,19,22,22,23},
			{11,11,13,12,15,14,15}
	};

	static int[] obsSum = new int[ANT_OBS];
	static int[] dagSum = new int[ANT_DAG];

	public static void summer() {
		
		for (int obsnr = 0; obsnr<ANT_OBS; obsnr++) {
			for (int dagnr = 0; dagnr <ANT_DAG; dagnr++) {
			
				obsSum[obsnr] = obsSum[obsnr] + temp[obsnr][dagnr];
			
				dagSum[dagnr] = dagSum[dagnr] + temp[obsnr][dagnr];
			}
		}
	}
	
	public static void skrivUt() {
		
		System.out.println("       man  tir  ons  tor  fre  lør  søn   snitt");
		System.out.println("------------------------------------------------");
		
		for (int obsnr = 0; obsnr<ANT_OBS; obsnr++) {
			System.out.print ("obs " + obsnr);
			

			for (int dagnr = 0; dagnr<ANT_DAG; dagnr++) {
				System.out.print("   " + temp[obsnr][dagnr]);
			}
			
			System.out.println("    " + obsSum[obsnr] / ANT_DAG);
		}
		
		System.out.println("------------------------------------------------");
		System.out.print("snitt");
		
		for (int dagnr = 0; dagnr <ANT_DAG; dagnr++) {
			System.out.print("   " + dagSum[dagnr] / ANT_OBS);
		}
	}
	
	public static void main(String[] args) {
		
		
		
		summer();
		skrivUt();

	}

}
