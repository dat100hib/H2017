package no.hvl.dat100.todo;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.Arrays;

/**
 * Eksempel paa applikasjon for romreservasjoner.
 *
 * @author "omskrevet fra"
 */
public class Romreservering {

	/**
	 * Skjuler konstruktoer slik at ingen andre kan lage instanser av denne klassen.
	 */
	private Romreservering() {
	}

	/**
	 * Programmet holder rede paa reservasjoner av ett rom, basert paa dato og
	 * klokkeslett (start-slutt). Klokkeslettene bruker Klokkeslett-klassen.
	 * Programmet sjekker at tidspunkt er lovlig angitt fra brukeren, og at det ikke
	 * blir kollisjon med tidligere reservasjoner.
	 *
	 * 
	 */
	public static void main(String[] args) {
		// Oppretter en tabell for aa holde paa reservasjoner
		final int MAKS_ANTALL_RESERVASJONER = 50;
		Reservasjon[] reservasjoner = new Reservasjon[MAKS_ANTALL_RESERVASJONER];

		int antall = 0;
		String svar;
		/*
		 * Programmet kjoerer til brukeren 'svarer' at det skal stoppe og at 
		 *  antall reservasjoner er mindre eller lik maks.
		 */

		do {
            //Innlesing
			String datoTekst = showInputDialog("Gi dato: aarsatall:mnd:dag");
			Dato dato = new Dato(datoTekst);
			String startTidTekst = showInputDialog("Gi start kl.: time:minutt");
			Klokkeslett startTid = new Klokkeslett(startTidTekst);
			String sluttTidTekst = showInputDialog("Gi slutt kl.: time:minutt");
			Klokkeslett sluttTid = new Klokkeslett(sluttTidTekst);
			
            //Test på lovlig dato og tid
			if (dato.lovlig() && startTid.lovlig() && sluttTid.lovlig()) {
				String ref = showInputDialog("Gi kontaktperson:");
				//Opprette et resevasjonsobjekt
				//TODO

				boolean ok = true;
				int nr = 0;
				//Test på kollisjon med andre reservajoner
				while (ok && nr < antall) {
					//TODO
				}
/* oppheve kommentarblokk senere
				if (ok) {
					reservasjoner[antall] = reservasjon;
					antall++;
				} else {
					System.out.println("Ikke reservert. Rom opptatt. " + reservasjon);
				}
			*/	
			} else {
				System.out.println("Ugyldig tidspunkt! Ingen reservasjon.");
			}

			svar = showInputDialog("Flere reservasjoner? (Ja/Nei):");
		} while (svar.equalsIgnoreCase("Ja") && antall <= MAKS_ANTALL_RESERVASJONER);

		String[] reservasjonsListe = new String[antall];
		for (int i = 0; i < antall; i++) {
			reservasjonsListe[i] = "" + reservasjoner[i];
		}

		// Sorterer alle reservasjonene etter dato, og innenfor
		// samme dag sorteres de paa klokkeslett.
		Arrays.sort(reservasjonsListe);

		String reservasjonsVisning = "Reservasjoner paa rommet";
		for (int i = 0; i < antall; i++) {
		 //Vise reservasjonsliste
		 //TODO	
		}

		showMessageDialog(null, reservasjonsVisning);

	}

}
