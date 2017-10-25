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

	private Scanner leser;
	
	public TekstUtsyn(Controller controller) {
		this.controller = controller;
		leser = new Scanner(System.in);
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
			System.out.println("Inntast valg:");
			
			int valg = leser.nextInt();

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
		
		EID eid = new EID();
		eid.readEID(leser);
		
		System.out.println("Organisations nummer: ");
		int orgnr = leser.nextInt();
		
		StatusCode status = controller.nyNeringsEiendom(eid.gns, eid.bns, orgnr);
		
		System.out.println(status.toString()); 
	}

	public void nyUtleieEiendom() {
		System.out.println("nyUtleieEiendom");
		
		EID eid = new EID();
		eid.readEID(leser);
		
		System.out.println("Leier fodselsnummer: ");
		int leier = leser.nextInt();
		
		System.out.println("Leiepris: ");
		int pris = leser.nextInt();
		
		StatusCode status = controller.nyUtleieEiendom(eid.gns, eid.bns, leier, pris);
		
		System.out.println(status.toString()); 
	}

	public void nyEier() {

		System.out.println("nyEier");
		
		System.out.println("navn: ");
		String navn = leser.nextLine();
		
		System.out.println("fodselsnummer: ");
		int fodselsnummer = leser.nextInt();
		
		System.out.println("vei: ");
		String vei = leser.nextLine();
		
		System.out.println("nummer: ");
		int nummer = leser.nextInt();
		
		System.out.println("postnummer: ");
		int postnummer = leser.nextInt();
		
		System.out.println("by: ");
		String by = leser.nextLine();
		
		System.out.println("land: ");
		String land = leser.nextLine();
		
		EID eid = new EID();
		eid.readEID(leser);
		
		KontaktAdresse adresse = new KontaktAdresse(vei,nummer,postnummer,by,land);
		
		StatusCode status = controller.nyEier(navn, fodselsnummer, adresse, eid.gns, eid.bns);
		
		System.out.println(status.toString()); 
	}
	
	public void nyEierEiendom() {

		System.out.println("nyEierEiendom");
		
		System.out.println("eier fodselsnummer: ");
		int fodselsnummer = leser.nextInt();
		
		EID eid = new EID();
		eid.readEID(leser);
		
		StatusCode status = controller.nyEierEiendom(fodselsnummer, eid.gns, eid.bns);
		
		System.out.println(status.toString()); 
	}

	public void registrerNabo() {

		System.out.println("registrerNabo");
		
		EID eid1 = new EID();
		eid1.readEID(leser);
		
		EID eid2 = new EID();
		eid2.readEID(leser);
		
		StatusCode status = controller.registrerNabo(eid1.gns, eid1.bns, eid2.gns, eid2.bns);
		
		System.out.println(status.toString()); 
		
	}

	private void skrivEier(Eier eier) {
		System.out.println(eier.getNavn()); // simpel representasjon av eier i dette utsyn
	}
	
	public void finnEiere() {

		System.out.println("finnEiere");
		
		EID eid = new EID();
		eid.readEID(leser);
		
		ArrayList<Eier> eiere = controller.finnEiere(eid.gns, eid.bns);
		
		if (eiere != null) {
			for (int i = 0; i<eiere.size(); i++)
				skrivEier(eiere.get(i));
		} else
			System.out.println("finnEiere feilet");
	}

	public void finnLeier() {
		
		System.out.println("finnEiere");
		
		EID eid = new EID();
		eid.readEID(leser);
		
		int fodselsnummer = controller.finnLeier(eid.gns, eid.bns);
		
		if (fodselsnummer >= 0)
			System.out.println("Leier fødselsnummer: " + fodselsnummer);
		else
			System.out.println("finnLeier feilet");
	}
}
