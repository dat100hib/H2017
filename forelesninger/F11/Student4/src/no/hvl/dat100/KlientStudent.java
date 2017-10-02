package no.hvl.dat100;

public class KlientStudent {

	public static void main(String[] args) {
		// I stedet for innlesing
		final String[] fagTab = { "MAT100", "INF101", "DAT100", "DAT102", "DAT103", "DAT104" };
		final char[] karTab = { 'C', 'D', 'C', 'B', 'E', 'A' };
        //snittpoeng = 3 + 2 + 3  + 4 + 1 + 5 = 18, snittpoeng = 3.0, altså gi snittkarakter C
		final String[] fagTab2 = { "MAT101", "INF102", "DAT106", "DAT153", };
		final char[] karTab2 = { 'C', 'E', 'C', 'D'};
		
		Navn ole = new Navn("Ole", "Olsen");
		Student olestud = new Student(1014, fagTab.length, ole, "DATA");
		olestud.setFag(fagTab);		
		olestud.setKarakterer(karTab);
		
		System.out.println(olestud);
		
		for(int i = 0; i < olestud.getAntFag(); i++){
			System.out.print(olestud.getFag()[i] + "\t") ;
		}
		
		System.out.println();
		
		for(int i = 0; i < olestud.getAntFag(); i++){
			System.out.print(olestud.getKarakterer()[i] + "\t") ;
		}
		
		System.out.println("\n"+ "Poengsum " + olestud.studiePoeng());
		
		System.out.println("Snittpoeng " + olestud.snittPoeng());
		
		System.out.println("Snittkarakter " + olestud.snittKarakter());
		
		//Utskrift av andre fag
		System.out.println("\n" + "Endre fag med karakterer");
		olestud.setAntFag(fagTab2.length);
		olestud.setFag(fagTab2);
		olestud.setKarakterer(karTab2);
		for(int i = 0; i < olestud.getAntFag(); i++){
			System.out.print(olestud.getFag()[i] + "\t") ;
		}
		
         System.out.println();
		
		for(int i = 0; i < olestud.getAntFag(); i++){
			System.out.print(olestud.getKarakterer()[i] + "\t") ;
		}
		
	}

}
