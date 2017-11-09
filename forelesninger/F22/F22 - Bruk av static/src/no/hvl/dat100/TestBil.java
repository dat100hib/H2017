package no.hvl.dat100;

public class TestBil {

	public static void main(String[] args) {
		Bil b1 = new Bil("ST-12345");
		Bil b2 = new Bil("ST-92345");
		Bil b3 = new Bil("ST-52345");
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		// Anbefalt måte å kalle klassemetode (statisk metode)
		System.out.println(Bil.nesteNr());

	}

}
