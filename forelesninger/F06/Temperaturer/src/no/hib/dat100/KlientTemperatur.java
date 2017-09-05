package no.hib.dat100;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static java.lang.String.format;

public class KlientTemperatur {

	public static void main(String[] args) {
		/* Programmet leser inn temperatur i celcius
		 * og skriver ut temperatur i fahrenheit
		 * om motsatt
		 * 
		 * Eks. 20C er 68F,  40F er 4.44, 0C er 32F,  212 F er 100C
		 */
		String melding ="";
		double celcius = 0.0;
		double fahrenheit = 0.0;
			
		//1. Fra celcius til fahrenheit
		String tallTxt = showInputDialog("Oppgi en temperatur i celcius :");
		celcius = parseDouble(tallTxt);
		fahrenheit = Temperatur.celsiusTilFahrenheit(celcius);
		melding =  "" + String.format("%6.2f",celcius) + " grader celcius er "  
				      + String.format("%6.2f",fahrenheit) + " grader fahrenheit";       

		showMessageDialog(null, melding);
		
		// 2. Fra fahrenheit til celcius
	    tallTxt = showInputDialog("Oppgi en temperatur i fahrenheit :");
	    fahrenheit = parseDouble(tallTxt);
		celcius = Temperatur.fahrenheitTilCelsius(fahrenheit);
		melding = "" + String.format("%6.2f", fahrenheit) + " grader fahrenheit er " 
		             + String.format("%6.2f", celcius) + " grader fahrenheit";

		showMessageDialog(null, melding);

	}

}
