package no.hvl.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

public class Meny {
	private Studentsamling studreg;
	private Grensesnitt gr;
	
	public Meny(Studentsamling studreg){
		gr = new Grensesnitt();
		this.studreg = studreg;
	};
	
	public void start(){ 
		System.out.println(" Meny");
		System.out.println(" 1 - Registrer");
		System.out.println(" 2 - Søk");
		System.out.println(" 3 - Slett");
		System.out.println(" 4 - VisAlle");
		System.out.println(" 5 - VisAlleSortert");
		System.out.println(" 9 - Avslutt");

		int nr = -1;
        int kode = -1;
        Student stud = null;
		do {
			String tallTxt = showInputDialog(" kode");
		    kode = parseInt(tallTxt);
			
			switch (kode) {

			case 1:
				gr.lesFlereStudenter(studreg);
				break;

			case 2:
				tallTxt = showInputDialog("oppgi studentnr med samme antall sifre");
				nr = parseInt(tallTxt);
				stud = studreg.sok(nr);
				if(stud == null){
					System.out.println("Studenten er ikke registerert");
				}else{
						System.out.println("Studenten som ble søkt etter:");
						gr.skrivStudent(stud);
					}				
				break;

			case 3:
				tallTxt = showInputDialog("oppgi studentnr");
				nr = parseInt(tallTxt);				
				stud = studreg.fjern(nr);
				if(stud == null){
					System.out.println("Studenten er ikke registerert");
				}else{
						System.out.println("Studenten som er slettet:");
						gr.skrivStudent(stud);
					}	
				break;

			case 4:
				gr.visAlle(studreg);
				break;
				
			case 5:
				gr.visAlleSortert(studreg);
				break;

			case 9: 
				System.out.println("\nAvsluttet");			
				break;

			default:
				System.out.println("Feil kode");			
			}
		} while (kode != 9);
	}
}


