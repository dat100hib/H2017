package no.hvl.dat100;

public class Gjennomsnitt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] tall = {71, 67, -35, -4, 83, 77, 12, 19};
        System.out.println("Vi har disse tallene: " + 
                           "71, 67, -35, -4, 83, 77, 12, 19");                
        int sum = 0;
        int antall = 0;        
        for (int detViSerPaa : tall) {            
            sum = sum + detViSerPaa;
            antall = antall + 1;
        }        
        double snitt = (double)sum / antall;        
        System.out.println("Gjennomsnittet er " + snitt);
     
	}

}