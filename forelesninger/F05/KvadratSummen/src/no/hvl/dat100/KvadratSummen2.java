package no.hvl.dat100;

public class KvadratSummen2 {

	public static void main(String[] args) {
		int kvadratSum = 0;
		int i = 1;
		while(i <= 10){
			 kvadratSum = kvadratSum + i*i;			
			 i = i +1;
		}
		System.out.println("Kvadratsummen er " + kvadratSum);


	}

}
