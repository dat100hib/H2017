package no.hib.dat100;

public class GangeTabell {
	public static void main(String args[]) {
		// Den gangetabellen
		for (int i = 1; i <= 10; i++) {
			System.out.println("Gangetabell for " + i);
			for(int j = 1; j <= 10; j++){
				System.out.println(i + "\tx\t" + j + "\ter\t" + (i*j));
			}
		}
	}
}
