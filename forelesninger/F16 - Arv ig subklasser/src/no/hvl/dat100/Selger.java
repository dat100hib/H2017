package no.hvl.dat100;

public class Selger extends Ansatt {
	private double bonus;
	
	public Selger() {
		super();
		bonus = 0.0;
	}
	public Selger(int nr, String fn, String en, double loenn, double bonus) {
		super(nr, fn, en, loenn);
		this.bonus = bonus;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public double getLoenn() {
		return loenn + bonus;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Bonus: " + bonus;
	}
}
