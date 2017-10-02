package no.hvl.dat100;

public class Utility {

	public static char poengTilKarakter(double p) {
		int poeng = (int) Math.round(p); // round gir long
		char kar = ' ';
		switch (poeng) {
		case 5:
			kar = 'A';
			break;
		case 4:
			kar = 'B';
			break;
		case 3:
			kar = 'C';
			break;
		case 2:
			kar = 'D';
			break;
		case 1:
			kar = 'E';
			break;
		case 0:
			kar = 'F';
			break;
		default:
			System.out.println("Ugyldig poeng");
		}

		return kar;
	}

	public static int karakterTilPoeng(char ka) {
		int poeng = -1;
		switch (ka) {
		case 'A':
			poeng = 5;
			break;
		case 'B':
			poeng = 4;
			break;
		case 'C':
			poeng = 3;
			break;
		case 'D':
			poeng = 2;
			break;
		case 'E':
			poeng = 1;
			break;
		case 'F':
			poeng = 0;
			break;
		default:
			System.out.println("Ugyldig karakter");
		}
		return poeng;
	}

}
