package no.hvl.dat100;

public class KlientStudent {

	public static void main(String[] args) {
		/* Oppretter et tomt student-objekt
		 * som får deafult-verdier
		 */
		Student s1;
		s1 = new Student();
		//Tildeling av verdier
		s1.studentNr = 141618;
		s1.fornavn = "Malin";
		s1.etternavn = "Dal";
		
		System.out.println(s1.studentNr + ": " + s1.fornavn + " " + s1.etternavn);
		
	}

}
