package no.hvl.dat100.kontakter;

public class KontaktListeSimpel {

	private static Kontakt[] kontakter;

	public static Kontakt finnPerson(String navn) {
	
		boolean funnet = false;
		Kontakt k = null;
		
		int i = 0;
		while (funnet == false && i<kontakter.length) {
			
			String kontaktnavn = kontakter[i].getNavn();
			
			if (navn.equals(kontaktnavn)) {
				funnet = true; 
				k = kontakter[i];
			}
			i++;
		}
		
		return k;
	}
	
	public static void main(String[] args) {
		
		Kontakt k1 = new Kontakt("Lars",55943623);
		Kontakt k2 = new Kontakt("Sven-Olai",55323223);
		
		System.out.println(k1.toString());
		System.out.println(k2.toString());
		
		kontakter = new Kontakt[2];
		
		kontakter[0] = k1;
		kontakter[1] = k2;

		Kontakt k3 = finnPerson("Lars");
		System.out.println(k3.toString());
		
		Kontakt k4 = finnPerson("Nemo");
		System.out.println(k4.toString());
	}

}
