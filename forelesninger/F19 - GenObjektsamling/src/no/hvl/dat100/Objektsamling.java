package no.hvl.dat100;

public class Objektsamling {
	private Element[] tab;
	private int nesteLedige;

	public Objektsamling(int antall) {
		tab = new Element[antall];
		nesteLedige = 0;
	}

	public boolean settInn(Element e) {
		if (nesteLedige < tab.length) {
			tab[nesteLedige] = e;
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

	private int finnPos(String s) {
		int p = 0;
		boolean funnet = false;

		while (!funnet && p < nesteLedige) {
			if (s.equals(tab[p].nokkel())) {
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

	public Element finn(String s) {
		int p = finnPos(s);
		if (p >= 0) {
			return tab[p];
		} else {
			return null;
		}
	}

	public boolean slett(String s) {
		int p = finnPos(s);
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
