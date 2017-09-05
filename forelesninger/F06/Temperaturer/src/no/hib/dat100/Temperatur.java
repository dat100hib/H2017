package no.hib.dat100;

public class Temperatur {

	public static double celsiusTilFahrenheit(double c) {
		return (c * 9 / 5) + 32;
	}

	public static double fahrenheitTilCelsius(double f) {
		return (f - 32) * 5 / 9;
	}

}
