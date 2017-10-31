package no.hvl.dat100;

public class Test {

	public static void main(String[] args) {

		Ansatt a1 = new Ansatt(1, "Ole", "Olsen", 100);
		Ansatt a2 = new Ansatt(2, "Kari", "Olsen", 105);
		Ansatt a3 = new Ansatt(3, "Ole", "Hansen", 110);
		
		Objektsamling ansatte = new Objektsamling(10);
		ansatte.settInn(a1);
		ansatte.settInn(a2);
		ansatte.settInn(a3);
		
		// Må ha tvungen typekonvertering ved uttak
		Ansatt k = (Ansatt) ansatte.finn("2");
		
		System.out.println(ansatte.finn("2"));
		
		Objektsamling boker = new Objektsamling(20);
		Bok b1 = new Bok("Forstå ...");
		boker.settInn(b1);
		System.out.println(boker.finn("Forstå ..."));
	}

}
