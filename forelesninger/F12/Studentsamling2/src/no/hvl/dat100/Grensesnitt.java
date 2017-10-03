package no.hvl.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.Arrays;

public class Grensesnitt {
	
	   
 // static-metoder for lesing og skriving
	public static void lesFlereStudenter(Studentsamling reg) {
		String ledetekst = "Programmmet leser inn studentopplsysninger";
		System.out.println(ledetekst);
		String tallTxt = showInputDialog("oppgi antall registreringer");
		int ant = parseInt(tallTxt);
		Student stud = null;

		for (int i = 0; i < ant; i++) {
			stud = lesStudent();
			reg.leggTil(stud);
		}		
	}

	public static void visAlle(Studentsamling reg) {
		System.out.println("\nAlle studenter");
		Student stud = null;
		for (int i = 0; i < reg.getAntall(); i++) {
			stud = reg.getSamling()[i];
			skrivStudent(stud);
		}
	}
	
	public static void visAlleSortert(Studentsamling reg){
		System.out.println("\nSkriver ut studentopplysningene sortert");
        //Sorterer en tabell som er strengobjekter av studentoppl..
		int stor = reg.getAntall();
		String[] nrTab = new String[stor];
		for (int i=0; i<nrTab.length; i++){
			  nrTab[i] = reg.getSamling()[i].skrivNr();
		}
		
		Arrays.sort(nrTab); // Kall til metode i klassen Arrays
		
		// Sortert utskrift etter studentnr
		for (int i = 0; i < nrTab.length; i++) {
			System.out.println(nrTab[i]);
		}	
		
	}

	public static Student lesStudent() {
		String tallTxt = showInputDialog("Oppgi studentnr: ");
		int nr = parseInt(tallTxt);
		String fornavn = showInputDialog("oppgi fornavn: ");
		String etternavn = showInputDialog("oppgi etternavn: ");
		Student student = new Student(nr, fornavn, etternavn);

		return student;
	}
		
	public static void skrivStudent(Student student) {
		System.out.println(student);	

	}
	
}
