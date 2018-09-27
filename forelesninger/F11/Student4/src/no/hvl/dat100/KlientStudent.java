package no.hvl.dat100;

public class KlientStudent {

	public static void main(String[] args) {
		
		// I stedet for innlesing Lag gjerne en klasse Grensesnitt som vist sist
		final String[] fagTab = { "MAT100", "INF101", "DAT100", "DAT102", "DAT103", "DAT104" };
		final char[] karTab = { 'C', 'D', 'C', 'B', 'E', 'A' };
        /*snittpoeng = 3 + 2 + 3  + 4 + 1 + 5 = 18,
		snittpoeng = 3.0, altså gi snittkarakter C */				
		Navn ole = new Navn("Ole", "Olsen");
		Student olestud = new Student(1014, fagTab.length, ole, "DATA");
		olestud.setFag(fagTab);		
		olestud.setKarakterer(karTab);
		System.out.println(olestud);		
		for(int i = 0; i < olestud.getAntFag(); i++){
			System.out.print(olestud.getFag()[i] + "\t" + "n") ;
		}
				
		for(int i = 0; i < olestud.getAntFag(); i++){
			System.out.print(olestud.getKarakterer()[i] + "\t") ;
		}		
		System.out.println("\n"+ "Poengsum " + olestud.studiePoeng());		
		System.out.println("Snittpoeng " + olestud.snittPoeng());		
		System.out.println("Snittkarakter " + olestud.snittKarakter());	
	}
	
}
