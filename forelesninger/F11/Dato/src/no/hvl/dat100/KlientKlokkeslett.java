package no.hvl.dat100;

public class KlientKlokkeslett {

	public static void main(String[] args) {
		Klokkeslett tid1 = new Klokkeslett(7, 15);
		System.out.println("tid1: " + tid1.toString());

		Klokkeslett tid2 = new Klokkeslett("10:03");
		System.out.println("tid2: " + tid2.toString());

		System.out.print("tid1: " + tid1.toString() + " er ");
		if (tid1.lovlig()) {
			System.out.println("et lovlig klokkeslett");
		} else {
			System.out.println("er ikke et lovlig klokkeslett");
		}
		System.out.print(tid1.toString() + " kommer ");
		if (tid1.foer(tid2)) {
			System.out.println("før " + tid2.toString());
		} else {
			System.out.println("etter " + tid2.toString());
		}
	}
}
