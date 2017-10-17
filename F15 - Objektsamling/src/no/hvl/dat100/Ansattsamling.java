package no.hvl.dat100;

public class Ansattsamling {
	private Ansatt[] tab;
	private int nesteLedige;

	public Ansattsamling(int antall) {
		tab = new Ansatt[antall];
		nesteLedige = 0;
	}

	public boolean settInn(Ansatt a) {
		if (nesteLedige < tab.length) {
			tab[nesteLedige] = a;
			nesteLedige++;
			return true;
		} else {
			return false;
		}

	}

	public String toString() {
		String svar = "";
		for (int i = 0; i < nesteLedige; i++) {
			svar += tab[i] + "\n";
		}
		return svar;
	}
	private int finnPos(int nr) {
		int p = 0;
		boolean funnet = false;

		while (!funnet && p < nesteLedige) {
			if (nr == tab[p].getNr()) {
				funnet = true;
			} else {
				p++;
			}
		}

		if (funnet) {
			return p;
		} else {
			return -1;
		}
	}

	public Ansatt finn(int nr) {
		int p = finnPos(nr);
		if (p >= 0) {
			return tab[p];
		} else {
			return null;
		}
	}

	public boolean finstFornavn(String s) {
		int p = 0;
		boolean funnet = false;

		while (!funnet && p < nesteLedige) {
			if (s.equals(tab[p].getFornavn())) {
				funnet = true;
			} else {
				p++;
			}
		}

		return funnet;
	}

	public boolean aukLoenn(int nr, double ekstra) {
		int p = finnPos(nr);
		if (p >= 0) {
			double nyLoenn = tab[p].getLoenn() + ekstra;
			tab[p].setLoenn(nyLoenn);
			return true;
		} else {
			return false;
		}
	}

	public boolean slett(int nr) {
		int p = finnPos(nr);
		if (p >= 0) {
			nesteLedige--;
			tab[p] = tab[nesteLedige];
			tab[nesteLedige] = null;
			return true;
		} else {
			return false;
		}
	}
}
