package no.hvl.dat100.utsyn.tekst;

import java.util.ArrayList;
import java.util.Scanner;

import no.hvl.dat100.kontroll.Controller;
import no.hvl.dat100.kontroll.Controller.StatusCode;
import no.hvl.dat100.modell.Eier;
import no.hvl.dat100.modell.KontaktAdresse;

public class TekstUtsyn {

	private Controller controller;

	final private static int NYNERINGSEIENDOM = 1;
	final private static int NYUTLEIEEIENDOM = 2;

	final private static int NYEIER = 3;
	final private static int NYEIEREIENDOM = 4;

	final private static int REGISTRERNABO = 5;
	final private static int FINNEIERE= 6;
	final private static int FINNLEIER = 7;
	
	final private static String SEPERATOR = "------------------------------------";
	
	final static int BREDDE = 25;

	private Leser leser;
	
	public TekstUtsyn(Controller controller) {
		this.controller = controller;
		leser = new Leser();
	}

	public void kjor() {

		boolean avslutt = false;

		do {
			System.out.println(SEPERATOR);
			System.out.println("Administrasjon av eiendommer");
			System.out.println(SEPERATOR);
			System.out.println("(1) - Ny næringseiendom");
			System.out.println("(2) - Ny utleieeiendom");
			System.out.println("(3) - Ny eier");
			System.out.println("(4) - Ny eier for eiendom");
			System.out.println("(5) - Registrer naboeiendom");
			System.out.println("(6) - Finn eiere for eiendom");
			System.out.println("(7) - Finn leier for utleieeiendom");
			System.out.println("Andre for avslutt");
			
			int valg = leser.lesInt("Inntast valg:");

			switch (valg) {
			case NYNERINGSEIENDOM:
				nyNeringsEiendom();
				break;
			case NYUTLEIEEIENDOM:
				nyUtleieEiendom();
				break;
			case NYEIER:
				nyEier();
				break;
			case NYEIEREIENDOM:
				nyEierEiendom();
				break;
			case REGISTRERNABO:
				registrerNabo();
				break;
			case FINNEIERE:
				finnEiere();
				break;
			case FINNLEIER:
				finnLeier();
				break;
			default:
				avslutt = true;
			}

		} while (!avslutt);

	}

	public void nyNeringsEiendom() {

		System.out.println("nyNæringsEiendom");
		
		int gns = leser.lesInt("Gårdsnummer : ");
		int bns = leser.lesInt("Bruksnummer : ");
		int orgnr = leser.lesInt("Organisations nummer: ");
		
		StatusCode status = controller.nyNeringsEiendom(gns, bns, orgnr);
		
		System.out.println(status.toString()); 
	}

	public void nyUtleieEiendom() {
		System.out.println("nyUtleieEiendom");
		
		int gns = leser.lesInt("Gårdsnummer : ");
		int bns = leser.lesInt("Bruksnummer : ");
		
		int leier = leser.lesInt("Leier fodselsnummer: ");
		int pris = leser.lesInt("Leiepris: ");
		
		StatusCode status = controller.nyUtleieEiendom(gns, bns, leier, pris);
		
		System.out.println(status.toString()); 
	}

	public void nyEier() {

		System.out.println("nyEier");
		
		String navn = leser.lesStreng("navn: ");
		int fodselsnummer = leser.lesInt("fodselsnummer: ");

		String vei = leser.lesStreng("vei: ");
		int nummer = leser.lesInt("nummer: ");
		int postnummer = leser.lesInt("postnummer: ");
		
		String by = leser.lesStreng("by: ");
		String land = leser.lesStreng("land: ");
		
		int gns = leser.lesInt("Gårdsnummer : ");
		int bns = leser.lesInt("Bruksnummer : ");
		
		KontaktAdresse adresse = new KontaktAdresse(vei,nummer,postnummer,by,land);
		
		StatusCode status = controller.nyEier(navn, fodselsnummer, adresse, gns, bns);
		
		System.out.println(status.toString()); 
	}
	
	public void nyEierEiendom() {

		System.out.println("nyEierEiendom");
		
		int fodselsnummer = leser.lesInt("eier fodselsnummer: ");
		
		int gns = leser.lesInt("Gårdsnummer : ");
		int bns = leser.lesInt("Bruksnummer : ");
		
		StatusCode status = controller.nyEierEiendom(fodselsnummer, gns, bns);
		
		System.out.println(status.toString()); 
	}

	public void registrerNabo() {

		System.out.println("registrerNabo");
		
		int gns1 = leser.lesInt("Gårdsnummer : ");
		int bns1 = leser.lesInt("Bruksnummer : ");
		
		int gns2 = leser.lesInt("Gårdsnummer : ");
		int bns2 = leser.lesInt("Bruksnummer : ");
		
		StatusCode status = controller.registrerNabo(gns1, bns1, gns2, bns2);
		
		System.out.println(status.toString()); 
		
	}

	private void skrivEier(Eier eier) {
		System.out.println(eier.getNavn()); // simpel representasjon av eier i dette utsyn
	}
	
	public void finnEiere() {

		System.out.println("finnEiere");
		
		int gns = leser.lesInt("Gårdsnummer : ");
		int bns = leser.lesInt("Bruksnummer : ");
		
		ArrayList<Eier> eiere = controller.finnEiere(gns, bns);
		
		if (eiere != null) {
			for (int i = 0; i<eiere.size(); i++)
				skrivEier(eiere.get(i));
		} else
			System.out.println("finnEiere feilet");
	}

	public void finnLeier() {
		
		System.out.println("finnEiere");
		
		int gns = leser.lesInt("Gårdsnummer : ");
		int bns = leser.lesInt("Bruksnummer : ");
		
		int fodselsnummer = controller.finnLeier(gns, bns);
		
		if (fodselsnummer >= 0)
			System.out.println("Leier fødselsnummer: " + fodselsnummer);
		else
			System.out.println("finnLeier feilet");
	}
}
