package no.hvl.dat100;

public class Trekant extends Figur {
	private int hoegde;
	private int grunnlinje;
	
	@Override
	public boolean equals(Object obj) {
		// Generert automatisk
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trekant other = (Trekant) obj;
		if (grunnlinje != other.grunnlinje)
			return false;
		if (hoegde != other.hoegde)
			return false;
		return true;
	}

	public Trekant(int hoegde, int grunnlinje) {
		super();
		this.hoegde = hoegde;
		this.grunnlinje = grunnlinje;
	}

	public int getHoegde() {
		return hoegde;
	}

	public void setHoegde(int hoegde) {
		this.hoegde = hoegde;
	}

	public int getGrunnlinje() {
		return grunnlinje;
	}

	public void setGrunnlinje(int grunnlinje) {
		this.grunnlinje = grunnlinje;
	}

	@Override
	public double areal() {
		// Viktig å ha med 2.0. Elles får vi heiltaldivisjon sidan både teljar og nemnar ville vore heiltal
		return (grunnlinje * hoegde)/2.0;
	}

	@Override
	public void tegn(char t) {
		// Antar grunnlinje == høgde
		
		for (int i = 0; i < hoegde; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(t);
			}
			System.out.println();
		}
	}

}
