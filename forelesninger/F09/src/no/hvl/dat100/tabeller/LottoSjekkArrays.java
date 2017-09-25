package no.hvl.dat100.tabeller;

import java.util.Arrays;

public class LottoSjekkArrays {

	static int[] lottoTall = {34,2,7,16,21,29,1};
	
	static int[] minKupong1 = {12,1,34,16,2,25,26};
	static int[] minKupong2 = {2,7,34,16,21,1,29};

	public static void main(String[] args) {

		Arrays.sort(lottoTall);
		Arrays.sort(minKupong1);
		Arrays.sort(minKupong2);
		
		boolean syvrett1 = Arrays.equals(lottoTall,minKupong1);
		boolean syvrett2 = Arrays.equals(lottoTall,minKupong2);
		
		System.out.println(syvrett1);
		System.out.println(syvrett2);
		
	}

}
