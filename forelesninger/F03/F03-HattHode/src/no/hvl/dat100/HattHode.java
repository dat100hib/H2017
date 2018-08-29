package no.hvl.dat100;
import easygraphics.*;

public class HattHode extends EasyGraphics {

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {
		makeWindow("HattHode", 270, 240);
		// Tegner hodet ved å fylle en gul sirkel
		setColor(255, 255, 0);
		fillCircle(100, 160, 70);

		// Tegner hatten ved å fylle to svarte rektangler
		setColor(0, 0, 0);
		fillRectangle(20, 100, 160, 25);
		fillRectangle(50, 25, 100, 75);
	}
}

