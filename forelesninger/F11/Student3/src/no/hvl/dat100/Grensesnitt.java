package no.hvl.dat100;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Grensesnitt {
	// Metoder for lesing og skriving

	public static Student lesStudent(){
		String tallTxt = showInputDialog("Oppgi studentnr: ");
		int nr = parseInt(tallTxt);
		String fornavn = showInputDialog("oppgi fornavn: ");
		String etternavn = showInputDialog("oppgi etternavn: ");
		Student student = new Student(nr, fornavn, etternavn);

		return student;
	}
	
	public static void skrivStudent(Student student){
		System.out.println(student.toString());		
		System.out.println();
	
	}
	
}
