package no.hvl.dat100.f01;

import easygraphics.*;

public class Grafikk extends EasyGraphics {

	static final long serialVersionUID = 1000L;

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {
		makeWindow("Grafikk", 350, 150);
		drawCircle(150, 70, 60);
	}

}
