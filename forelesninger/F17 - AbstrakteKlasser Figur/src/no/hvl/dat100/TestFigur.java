package no.hvl.dat100;

public class TestFigur {

	public static void main(String[] args) {
		Rektangel r = new Rektangel(2, 4);
		System.out.println("Areal: " + r.areal());
		r.tegn('+');
		
		Rektangel s = new Rektangel(2, 4);
		Rektangel t = r;
		
		// Om vi fjernar equals i Rektangel, vil første setningen nedanfor gi false
		// den andre true (sidan r og t referer til same objekt)
		System.out.println(r.equals(s));
		System.out.println(r.equals(t));
		
		Trekant t1 = new Trekant(3, 3);
		System.out.println("Areal: " + t1.areal());
		t1.tegn('-');
		
		Figur[] ft = new Figur[5];
		ft[0] = r;
		ft[1] = t1;
		ft[2] = s;
		ft[3] = new Trekant(4, 7);
		ft[4] = new Rektangel(2, 3);
		
		System.out.println("Figurar i tabell");
		for (Figur f : ft) {
			f.tegn('+');
			System.out.println();
		}
		
		double samletAreal = 0.0;
		for (Figur f : ft) {
			samletAreal += f.areal();
		}
		
		System.out.println("Samlet areal: " + samletAreal);
	}

}
