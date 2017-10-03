package no.hvl.dat100;

import java.util.Arrays;

public class KlientStudentsamling {

	public static void main(String[] args) {
		 Studentsamling studreg = new Studentsamling();
		 Meny meny = new Meny(studreg);
		 meny.start();		
	}
		
}// class
