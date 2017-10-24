package no.hvl.dat100;

public class Rektangel extends Figur {
	private int hoegde;
	private int bredde;
	
	public Rektangel(int h, int b) {
		hoegde = h;
		bredde = b;
	}

	public int getHoegde() {
		return hoegde;
	}

	public void setHoegde(int hoegde) {
		this.hoegde = hoegde;
	}

	public int getBredde() {
		return bredde;
	}

	public void setBredde(int bredde) {
		this.bredde = bredde;
	}
	
	@Override
	public double areal() {
		return hoegde * bredde;
	}
	
	@Override
	public void tegn(char t) {
		for (int i = 0; i < hoegde; i++) {
			for (int j = 0; j < bredde; j++) {
				System.out.print(t);
			}
			System.out.println();
		}
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		
		if (other == null ||  !(other instanceof Rektangel)){
			return false;
		}
		
		Rektangel r = (Rektangel) other;
		return hoegde == r.hoegde && bredde == r.bredde;
	}
}
