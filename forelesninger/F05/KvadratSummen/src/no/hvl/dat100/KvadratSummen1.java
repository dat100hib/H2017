package no.hvl.dat100;

public class KvadratSummen1 {

	public static void main(String[] args) {
		int kvadratSum = 0;
		for(int i = 1; i <= 10;i++){
			 kvadratSum = kvadratSum + i*i;			
		}
		System.out.println("Kvadratsummen er " + kvadratSum);


	}

}