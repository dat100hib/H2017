package easygraphics;

import java.awt.Color;

/*  Klassen inneholder diverse konstanter,
 *  referanse til køen av animasjonssteg,
 *  og fellesmetoder for bla. utskrift av feilmeldinger.
 */
public class EGCommon {

  // Skal settes til false i ferdig løsning
  public  static final boolean DEBUG = false;
  
  // Skal tegnevinduet lukkes og programmet avsluttes
  // når alle operasjoner er utført? Hvis ikke, må
  // brukeren selv lukke vinduet.
  public  static final boolean EXIT_ON_FINISH = false;
  
  // Standardstørrelse på tegnevinduet
  public  static final int     STD_WIDTH = 800;
  public  static final int     STD_HEIGHT = 800;
  
  // Standardfarger
  public  static final Color   STD_BACKGROUND = Color.WHITE;
  public  static final Color   STD_COLOR = Color.BLACK;
  
  // Standardfont
  public  static final String  STD_FONT = "Arial";
  public  static final int     STD_FONT_SIZE = 12;
  
  // Standardfart og hvor mye farten skal "skaleres".
  public  static final int     STD_SPEED = 10;
  public  static final int     STD_SPEED_SLOWDOWN = 1;
  
  // Stegkøene
  public  static final int     INIT_STEPS = 500;  // Antall steg i animasjonskø ved opprettelse
  public  static final int     MAX_STEPS  = 5000; // Max steg i én animasjonskø
  public  static final int     MAX_QUEUES = 10;   // Max antall animasjonskøer (før venting)
  public  static final int     WAIT_TIME  = 500;  // Ventetid mellom forsøk på innsetting av kø
  
  // Datastrukturen som håndterer stegkøene
  public  static EGBuffer      stepBuffer;
  
  // Objekt for å synkronisere hoved-tråden og event-tåden
  public  static EGLatch       latch = new EGLatch();
  
  // For måling av tidsbruk (brukes kun under testing)
  private static long          startTime;
  
  
  
  public static void logMessage(String msg) {
    if (DEBUG)
      System.out.println(msg);
  }
  
  
  public static void fatalError(String msg) {
    System.out.println("Fatal error: " + msg);
    System.exit(-1);
  }
  
  
  public static void startup() {
    startTime = System.currentTimeMillis();
    stepBuffer = new EGBuffer();
  }
  
  
  public static void finish() {
    if (EGCommon.DEBUG) {
      long duration = System.currentTimeMillis() - startTime;
      System.out.println("Duration: " + duration/1000.0 + "s.");
    }
    
    if (EGCommon.EXIT_ON_FINISH)  
      System.exit(0);
    else
      System.out.println("Lukk tegnevinduet...");
  }

}