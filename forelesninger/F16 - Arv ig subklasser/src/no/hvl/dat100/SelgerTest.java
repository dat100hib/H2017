package no.hvl.dat100;

public class SelgerTest {

	public static void main(String[] args) {
		Selger s = new Selger(5, "Ole", "Olsen", 400000, 20000);
		System.out.println(s.toString());
		s.setFornavn("Ola");
		System.out.println(s);
		
		Ansatt a = new Selger(1, "Lise", "Olsen", 450000, 25000);
		System.out.println(a.getLoenn());
		
		Ansatt[] aTab = new Ansatt[3];
		aTab[0] = s;
		aTab[1] = a;
		aTab[2] = new Ansatt(3, "Fredrik", "Mørk", 800000);
		
		for (Ansatt b : aTab) {
			System.out.println(b);
		}
		
		System.out.println(aTab[2].getEtternavn());
		
		// Summen av all lønn
		double tot = 0.0;
		for (Ansatt b : aTab) {
			tot += b.getLoenn();
		}
		System.out.println(tot);
		
		// Meir enn 460000 i løn
		for (Ansatt b : aTab) {
			if (b.getLoenn() >= 460000) {
				System.out.println(b);
			}
		}
		System.out.println(tot);
	}

}
