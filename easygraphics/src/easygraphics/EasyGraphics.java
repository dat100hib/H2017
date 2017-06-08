package easygraphics;

import java.awt.*;
import java.lang.reflect.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;


/** <p>Klassen EasyGraphics tilbyr metoder for å tegne og flytte ("animere")
  * linjer, rektangel, sirkler, ellipser, sirkelbuer og tekst.</p>
  *
  * <p>Klassen er et lite overbygg på Swing. Ved å bruke EasyGraphics kan 
  * man bli kjent med grafikk og animasjon på en enkel måte.</p>
  *
  * <p>Her er et eksempelprogram som gjør følgende:</p>
  *
  * <ul>
  * <li>Setter opp grafikkvinduet med en tegneflate med tittel "GrafikkDemo" 
  * og bredde=høyde=500 (makeWindow).</li>
  * <li>Setter halv fart på animasjonen (setSpeed).</li>
  * <li>Tegner et blått rektangel med bredde=40 og høyde=80 (drawRectangle). 
  * Det øvre, venstre hjørnet blir plassert i (x=200, y=300).</li>
  * <li>Fyller en sirkel med gul farge (fillCircle). Sirkelen har radius=10 og
  * midtpunkt (x=100, y=100).</li>
  * <li>Flytter (det øverste, venstre hjørnet i) rektangelet til (x=300, y=400) 
  * med metode moveRectangle.</li>
  * <li>Flytter (midtpunktet i) sirkelen til (x=200, y=200) med metoden
  * moveCircle.</li>
  * </ul>
  *
  * <p>&nbsp;</p>
  *
  * <pre>
  * public class GrafikkDemo extends EasyGraphics {
  *
  *   public static void main(String[] args) {
  *     launch(args);
  *   }
  *
  *   public void run() {
  *     makeWindow("GrafikkDemo", 500, 500);
  *     setSpeed(5);
  *     setColor(0, 0, 255);
  *     int rid = drawRectangle(200, 300, 40, 80);
  *     setColor(255, 255, 0);
  *     int sid = fillCircle(100, 100, 10);
  *     moveRectangle(rid, 300, 400);
  *     moveCircle(sid, 200, 200);
  *   }
  * }
  *  </pre>
  * 
  * <p>For to-dimensjonale geometriobjekt kan man velge å tegne omriss 
  * (drawRectangle) eller å fylle med farge (fillRectangle). Aktiv farge 
  * settes med en egen metode setColor. Fonten til tekststrenger kan settes 
  * med metoden setFont.</p>
  *
  * <p>Metoder som tegner objektene (f.eks. drawCircle og fillCircle) returnerer 
  * en unik node-id, som senere kan brukes for å flytte eller reskalere objektet
  * (tekstobjekt kan ikke reskaleres). Alle objekt kan skjules/vises (setVisible).</p>
  *
  * <p>Geometriobjekt posisjoneres, flyttes og reskaleres i forhold til et bestemt 
  * punkt på objektet:</p>
  *
  * <ul>
  * <li>Linjer: Startpunktet</li>
  * <li>Rektangel: Øverste, venstre hjørne</li>
  * <li>Sirkler: Midpunktet</li>
  * <li>Ellipser: Midtpunktet</li>
  * <li>Sirkelbuer: Midtpunktet (i sirkelen)</li>
  * <li>Tekststrenger: Nedre (fotlinjen), venstre hjørne</li>
  * </ul>
  *
  * <p>Farten på en animasjon blir bestemt ved metoden setSpeed, der  
  * parameter 1 = langsom, ..., 10 = hurtig. Det er også mulig å legge inn
  * pauser i en animasjon (metode pause).</p>
  *
  * <p>Nettsidene til
  * <a href="http://www.nettressurser.no/programmering" target="_top">
  * Forstå programmering</a> forklarer hvordan man kan kompilere og
  * kjøre EasyGraphics-program.</p>
  *
  * @version 1.1
  *
  * <p>Sist endret: 19.03.2013</p>
  *
  */
public abstract class EasyGraphics extends JFrame {

  private static final Integer ANY_TYPE       = 0;
  private static final Integer ARC_TYPE       = 1;
  private static final Integer CIRCLE_TYPE    = 2;
  private static final Integer ELLIPSE_TYPE   = 3;
  private static final Integer LINE_TYPE      = 4;
  private static final Integer RECTANGLE_TYPE = 5;
  private static final Integer STRING_TYPE    = 6;

  
  private Color  background = EGCommon.STD_BACKGROUND;
  private Color  color      = EGCommon.STD_COLOR;
  private Font   font       = new Font(EGCommon.STD_FONT, Font.PLAIN, EGCommon.STD_FONT_SIZE);
  private int    speed      = EGCommon.STD_SPEED;
  
  // Inndata fra brukeren
  private String response;        
  
  // For å sjekke korrekt figurtype ved move/resize
  private ArrayList<Integer> figTypes = new ArrayList<Integer>();
  
  // Neste ledige figur-id
  private int figCount   = 0;  
  
  // For å sjekke at brukerprogrammet kaller på launch først
  private static boolean launchedCalled = false;
  
  private static EGGui   gui;
  

  
  // *************************************************
  // Oppstart-metodene
  // *************************************************
  
  
  /** 
   *  Setter opp vinduet og kaller run. Kalles fra main.
   *
   *  @param args kommandolinjeparametre (brukes ikke foreløpig)
   *
   */
  public static void launch(String[] args) {
    launchedCalled = true;
    EGCommon.startup();
    
    // Opprett GUI på event-tråden
    EasyGraphics app = getApp();
    gui = new EGGui(app);
    SwingUtilities.invokeLater(gui);
    EGCommon.latch.awaitStartup();
    
    // Kjør brukerprogrammet på en egen tråd
    EGRunner runner = new EGRunner(app);
    Thread thread = new Thread(runner);
    thread.start();
  }

 
 
  /** 
   *  Utfører tegne- og animasjons-operasjoner.
   *  Denne metoden må deklareres (overstyres).
   *  I grafikkprogram spiller denne rollen som "sjefsmetode" (a la main).
   *
   */
  public abstract void run();
  
  
  
  
  // *************************************************
  // Tegnemetoder
  // *************************************************
  
  
  /** 
   *  Tegner en sirkelbue med aktiv farge. Returnerer en unik id som kan
   *  brukes for å flytte sirkelbuen.
   *
   *  @param centerX x-koordinat til midtpunktet
   *  @param centerY y-koordinat til midtpunktet
   *  @param radiusX "horisontal radius", må være større enn 0
   *  @param radiusY "vertikal radius", må være større enn 0
   *  @param startAngle startvinkel
   *  @param angleLength vinkellengde
   *  @return unik node-id
   *
   */
  public int drawArc(int centerX, int centerY, 
                     int radiusX, int radiusY, 
                     int startAngle, int angleLength) {
    return makeArc(centerX, centerY, radiusX, radiusY, startAngle, angleLength, false);
  }
  
  
  /** 
   *  Tegner en sirkel med aktiv farge. Returnerer en unik id som kan 
   *  brukes for å flytte sirkelen.
   *
   *  @param centerX x-koordinat til midtpunktet
   *  @param centerY y-koordinat til midtpunktet
   *  @param radius radius, må være større enn 0
   *  @return unik node-id
   *
   */
  public int drawCircle(int centerX, int centerY, int radius) {
    return makeCircle(centerX, centerY, radius, false);
  }
  
  
  /** 
   *  Tegner en ellipse med aktiv farge. Returnerer en unik id som kan 
   *  brukes for å flytte ellipsen.
   *
   *  @param centerX x-koordinat til midtpunktet
   *  @param centerY y-koordinat til midtpunktet
   *  @param radiusX "horisontal radius", må være større enn 0
   *  @param radiusY "vertikal radius", må være større enn 0
   *  @return unik node-id
   *
   */
  public int drawEllipse(int centerX, int centerY, int radiusX, int radiusY) {
    return  makeEllipse(centerX, centerY, radiusX, radiusY, false);
  }
  
  
  /** 
   *  Tegner en rett linje med aktiv farge. Returnerer en unik id som kan 
   *  brukes for å flytte linjen.
   *
   *  @param startX x-koordinat for startpunkt
   *  @param startY y-koordinat for startpunkt
   *  @param endX x-koordinat for endepunkt
   *  @param endY y-koordinat for endepunkt
   *  @return unik node-id
   *
   */
  public int drawLine(int startX, int startY, int endX, int endY) {
    return makeLine(startX, startY, endX, endY, false);
  }
  
  
  /** 
   *  Tegner et rektangel med aktiv farge. Returnerer en unik id som kan 
   *  brukes for å flytte rektangelet.
   *
   *  @param minX x-koordinat for venstre side
   *  @param minY y-koordinat for øvre side
   *  @param width bredde, må være større enn 0
   *  @param height høyde, må være større enn 0
   *  @return unik node-id
   *
   */
  public int drawRectangle(int minX, int minY, int width, int height) {
    return makeRectangle(minX, minY, width, height, false);
  }
  
  
  /** 
   *  Tegner tekst med aktiv font og farge. Returnerer en unik id som kan 
   *  brukes for å flytte teksten.
   *
   *  @param x x-koordinat til venstre kant
   *  @param y y-koordinat til nedre kant
   *  @param str tekststrengen
   *  @return unik node-id
   *
   */
  public int drawString(String str, int x, int y) {
    return makeString(x, y, str, false);
  }
  
  
  /** 
   *  Fyller en sirkelbue ("kakestykke") med aktiv farge. Returnerer en 
   *  unik id som kan brukes for å flytte sirkelbuen.
   *
   *  @param centerX x-koordinat til midtpunktet
   *  @param centerY y-koordinat til midtpunktet
   *  @param radiusX "horisontal radius", må være større enn 0
   *  @param radiusY "vertikal radius", må være større enn 0
   *  @param startAngle startvinkel
   *  @param angleLength vinkellengde
   *  @return unik node-id
   *
   */
  public int fillArc(int centerX, int centerY, int radiusX, 
                     int radiusY, int startAngle, int angleLength) {
    return makeArc(centerX, centerY, radiusX, radiusY, startAngle, angleLength, true);
  }
  
  
  /** 
   *  Fyller en sirkel med aktiv farge. Returnerer en unik id som kan 
   *  brukes for å flytte sirkelen.
   *
   *  @param centerX x-koordinat til midtpunktet
   *  @param centerY y-koordinat til midtpunktet
   *  @param radius radius, må være større enn 0
   *  @return unik node-id
   *
   */
  public int fillCircle(int centerX, int centerY, int radius) {
    return makeCircle(centerX, centerY, radius, true);
  }
  
  
  /** 
   *  Tegner en ellipse med aktiv farge. Returnerer en unik id som kan 
   *  brukes for å flytte ellipsen.
   *
   *  @param centerX x-koordinat til midtpunktet
   *  @param centerY y-koordinat til midtpunktet
   *  @param radiusX "horisontal radius", må være større enn 0
   *  @param radiusY "vertikal radius", må være større enn 0
   *  @return unik node-id
   *
   */
  public int fillEllipse(int centerX, int centerY, 
                         int radiusX, int radiusY) {
    return makeEllipse(centerX, centerY, radiusX, radiusY, true);
  }
  
  
  /** 
   *  Fyller et rektangel med aktiv farge. Returnerer en unik id som kan 
   *  brukes for å flytte rektangelet.
   *
   *  @param minX x-koordinat for venstre side
   *  @param minY y-koordinat for øvre side
   *  @param width bredde, må være større enn 0
   *  @param height høyde, må være større enn 0
   *  @return unik node-id
   *
   */
  public int fillRectangle(int minX, int minY, int width, int height) {
    return makeRectangle(minX, minY, width, height, true);
  }
  
  
  /** 
   *  Leser inn en tekststreng fra brukeren, via et tekstfelt
   *  øverst i vinduet.
   *
   *  @param msg meldingen til bruker
   *
   */ 
  public String getText(String msg) {
    checkLaunched();
    
    // La eventuelle animasjoner avslutte  
    EGFinishStep finish = new EGFinishStep();
    addStep(finish);
    addQueue();
    EGCommon.latch.awaitAnimation();
    
    // Vent på inndata fra brukeren
    EGInput reader = new EGInput(gui, msg);
    SwingUtilities.invokeLater(reader);
    EGCommon.latch.awaitUser();
    
    String response = gui.getResponse();
    return response;
  }
  
  
  /** 
   *  Konfigurerer vinduet med standard størrelse bredde=høyde=800 piksler.
   *
   *  @param title tittelen til vinduet
   *
   */
  public void makeWindow(String title) {
    makeWindow(title, EGCommon.STD_WIDTH, EGCommon.STD_HEIGHT);
  }
 
  
  /** 
   *  Konfigurerer vinduet.
   *
   *  @param title tittelen til vinduet
   *  @param width bredden til vinduet, må være større enn 0
   *  @param height høyden til vinduet, må være større enn 0
   *
   */
  public void makeWindow(String title, int width, int height) {
    checkLaunched();
    checkPositive(width, "width");
    checkPositive(height, "height");
    EGWindowStep step = new EGWindowStep(gui, title, width, height);
    addStep(step);
  }
  
  
  /** 
   *  Flytter ("animerer") figuren med gitt node-id til et gitt punkt
   *  langs en rett linje. Se tilsvarende moveXXX-metoder tilpasset
   *  de ulike figurtypene for hvor på figuren punktet (x,y) refererer. 
   *
   *  @param id node-id
   *  @param x x-koordinatet til ny posisjon
   *  @param y y-koordinatet til ny posisjon
   *
   */
  public void move(int id, int x, int y) {
    moveFigure(id, x, y, ANY_TYPE);
  }
  
  
  /** 
   *  Flytter ("animerer") sirkelbuen med gitt node-id til et gitt punkt
   *  langs en rett linje. Den nye posisjonen vil være midtpunktet 
   *  i "tilhørende" sirkel.
   *
   *  @param id node-id
   *  @param x x-koordinatet til ny posisjon
   *  @param y y-koordinatet til ny posisjon
   *
   */
  public void moveArc(int id, int x, int y) {
    moveFigure(id, x, y, ARC_TYPE);
  }
  
  
  /** 
   *  Flytter ("animerer") sirkelen med gitt node-id til et gitt punkt 
   *  langs en rett linje. Den nye posisjonen vil være midtpunktet i sirkelen.
   *
   *  @param id node-id
   *  @param x x-koordinatet til ny posisjon
   *  @param y y-koordinatet til ny posisjon
   *
   */
  public void moveCircle(int id, int x, int y) {
    moveFigure(id, x, y, CIRCLE_TYPE);
  }
  
  
  /** 
   *  Flytter ("animerer") ellipsen med gitt node-id til et gitt punkt langs
   *  en rett linje. Den nye posisjonen vil være midtpunktet i ellipsen.
   *
   *  @param id node-id
   *  @param x x-koordinatet til ny posisjon
   *  @param y y-koordinatet til ny posisjon
   *
   */
  public void moveEllipse(int id, int x, int y) {
    moveFigure(id, x, y, ELLIPSE_TYPE);
  }
  
  
  /** 
   *  Flytter ("animerer") linjen med gitt node-id til et gitt punkt langs 
   *  en rett linje. Den nye posisjonen vil være startpunktet til linjen.
   *
   *  @param id node-id
   *  @param x x-koordinatet til ny startposisjon
   *  @param y y-koordinatet til ny startposisjon
   *
   */
  public void moveLine(int id, int x, int y) {
    moveFigure(id, x, y, LINE_TYPE);
  }
  
  
  /** 
   *  Flytter ("animerer") rektangelet med gitt node-id til et gitt punkt langs
   *  en rett linje. Den nye posisjonen vil være øverste, venstre hjørne i
   *  rektangelet.
   *
   *  @param id node-id
   *  @param x x-koordinatet til ny posisjon
   *  @param y y-koordinatet til ny posisjon
   *
   */
  public void moveRectangle(int id, int x, int y) {
    moveFigure(id, x, y, RECTANGLE_TYPE);
  }
  
  
  /** 
   *  Flytter ("animerer") teksten med gitt node-id til et gitt punkt langs
   *  en rett linje. Den nye posisjonen vil være nedre, venstre punkt
   *  i teksten.
   *
   *  @param id node-id
   *  @param x x-koordinatet til ny posisjon
   *  @param y y-koordinatet til ny posisjon
   *
   */
  public void moveString(int id, int x, int y) {
    moveFigure(id, x, y, STRING_TYPE);
  }
  
  
  /** 
   *  Legger inn en pause i animasjonen.
   *
   *  @param ms varighet i antall millisekunder, må være større enn 0
   *
   */
  public void pause(int ms) {
    checkLaunched();
    checkPositive(ms, "ms");
    EGPauseStep step = new EGPauseStep(ms);
    addStep(step);
  }
  
 
  /** 
   *  Skriver ut en tekst til konsollet på riktig
   *  tidspunkt (i forhold til pågående animasjoner).
   *
   *  @param msg meldingen
   *
   */
  public void print(String msg) {
    checkLaunched();
    EGPrintStep step = new EGPrintStep(msg);
    addStep(step);
  }
  
  
  /** 
   *  Skriver ut en tekst med linjeskift til konsollet
   *  på riktig tidspunkt (i forhold til pågående animasjoner).
   *
   *  @param msg meldingen
   *
   */
  public void println(String msg) {
    checkLaunched();
    EGPrintStep step = new EGPrintStep(msg + "\n");
    addStep(step);
  }
  
  
  /** 
   *  Endrer størrelse ("animerer") på sirkelbuen med gitt node-id.
   *
   *  @param id node-id
   *  @param rX ny "x-radius", må være større enn 0
   *  @param rY ny "y-radius", må være større enn 0
   *
   */
  public void resizeArc(int id, int rX, int rY) {
    checkLaunched();
    checkPositive(rX, "rX");
    checkPositive(rY, "rY");
    resize(id, 2*rX, 2*rY, ARC_TYPE);
  }
  
  
  /** 
   *  Endrer størrelse ("animerer") på sirkelen med gitt node-id.
   *
   *  @param id node-id
   *  @param r ny radius, må være større enn 0
   *
   */
  public void resizeCircle(int id, int r) {
    checkLaunched();
    checkPositive(r, "r");
    resize(id, 2*r, 2*r, CIRCLE_TYPE);
  }
  
  
  /** 
   *  Endrer størrelse ("animerer") på ellipsen med gitt node-id.
   *
   *  @param id node-id
   *  @param rX ny "x-radius", må være større enn 0
   *  @param rY ny "y-radius", må være større enn 0
   *
   */
  public void resizeEllipse(int id, int rX, int rY) {
    checkLaunched();
    checkPositive(rX, "rX");
    checkPositive(rY, "rY");
    resize(id, 2*rX, 2*rY, ELLIPSE_TYPE);
  }
  
  
  /** 
   *  Endrer størrelse ("animerer") på linjen med gitt node-id.
   *  Det gjøres ved å forskyve endepunktet, startpunktet ligger fast.
   *
   *  @param id node-id
   *  @param w ny bredde, må være større enn 0
   *  @param h ny høyde, må være større enn 0
   *
   */
  public void resizeLine(int id, int w, int h) {
    checkLaunched();
    checkPositive(w, "w");
    checkPositive(h, "h");
    resize(id, w, h, LINE_TYPE);
  }
  
  
  /** 
   *  Endrer størrelse ("animerer") på rektangelet med gitt node-id.
   *
   *  @param id node-id
   *  @param w ny bredde, må være større enn 0
   *  @param h ny høyde, må være større enn 0
   *
   */
  public void resizeRectangle(int id, int w, int h) {
    checkLaunched();
    checkPositive(w, "w");
    checkPositive(h, "h");
    resize(id, w, h, RECTANGLE_TYPE);
  }

  
  /** 
   *  Setter bakgrunnsfarge med et RGB-trippel.
   *
   *  @param r rød verdi mellom 0 og 255
   *  @param g grønn verdi mellom 0 og 255
   *  @param b blå verdi mellom 0 og 255
   *
   */
  public void setBackground(int r, int g, int b) {
    checkLaunched();
    checkInterval(r, 0, 255, "r");
    checkInterval(g, 0, 255, "g");
    checkInterval(b, 0, 255, "b");
    EGGlobalStep step = new EGGlobalStep(r, g, b);
    addStep(step);
  } 
  
  
  /** 
   *  Setter aktiv farge med et RGB-trippel. Geometriobjekt som blir
   *  tegnet vil heretter få denne fargen (helt fram til neste kall
   *  på setColor).
   *
   *  @param r rød verdi mellom 0 og 255
   *  @param g grønn verdi mellom 0 og 255
   *  @param b blå verdi mellom 0 og 255
   *
   */
  public void setColor(int r, int g, int b) {
    checkLaunched();
    boolean ok = checkInterval(r, 0, 255, "r")
              && checkInterval(g, 0, 255, "g")
              && checkInterval(b, 0, 255, "b");
    if (ok)
      color = new Color(r, g, b);
  }
  
  
  /** 
   *  Setter aktiv font. Tekststrenger som blir tegnet vil heretter få
   *  denne fargen (helt fram til neste kall på setFont).
   *
   *  @param name navn på font-familien
   *  @param size fontstørrelsen, må være større enn 0
   *
   */
  public void setFont(String name, int size) {
    checkLaunched();
    boolean ok = checkPositive(size, "size");
    if (ok)
      font = new Font(name, Font.PLAIN, size);
  }
  
  
  /** 
   *  <p>Setter farten på animasjonen.</p>
   *
   *  <p>Metoden tilbyr en meget enkel måte å styre farten til animasjoner
   *   på. Den setter kun inn en kort pause mellom hvert "steg".</p>
   *  <p>Hastigheten til en animasjon vil bla. variere med hvilken maskin 
   *  man bruker, og om man f.eks. gjør (få og) lange eller (mange og) korte
   *  forflytninger/reskaleringer. I det siste tilfellet bør endringen være
   *  4 eller kortere i både x- og y-retning.</p>
   *  <p>For å oppnå ønsket fart må man eksperimentere litt i hvert enkelt
   *  tilfelle.</p>
   *  
   *  @param speed farten fra 1 (langsomt) til 10 (hurtig)
   *
   */
  public void setSpeed(int speed) {
    checkLaunched();
    checkInterval(speed, 1, 10, "speed");
    EGGlobalStep step = new EGGlobalStep(speed);
    addStep(step);
    
    // Flere korte forflytninger på ulike objekt blir utført i parallell.
    // Konstanten EGFigure.DELTA (privat i denne klassen) bestemmer øvre
    // grense for lengden på slike operasjoner.
  }
  
  
  /** 
   *  Viser/skjuler et geometriobjekt.
   *
   *  @param id node-id
   *  @param visible skal objektet vises?
   *
   */
  public void setVisible(int id, boolean visible) {
    checkLaunched();
    EGShowStep step = new EGShowStep(id, visible);
    addStep(step);
  }
  
  
  
  // *************************************************
  // Hjelpemetoder.
  // *************************************************

  
  /*  Legger til et nytt animasjonssteg bakerst
   *  i inn-køen.
   */
  private void addStep(EGStep step) {
    EGCommon.stepBuffer.addStep(step);
  }
 

  /*  Legger inn-køen inn til i bufferet av køer
   *  for behandling på event-tråden.
   */ 
  private void addQueue() {
    EGCommon.stepBuffer.addQueue();
  }
  
 

  /*  Sjekker at det for en gitt id er opprettet en
   *  figur av korrekt type.
   */   
  private void checkFigure(int id, Integer figType) {
    if (id < 0 || id >= figTypes.size()) {
      String msg = "Unknown figure id : " + id;
      EGErrorStep step = new EGErrorStep(msg);
      addStep(step);
    }  
    else {
      Integer ft = figTypes.get(id);
       
      if (ft != figType && figType != ANY_TYPE) {
        String msg = "Figure " + id + " is not a " + figTypeToString(figType);
        EGErrorStep step = new EGErrorStep(msg);
        addStep(step);
      }
    }
  } 

  
  /*  Sjekker at en parameter til en av EasyGraphics-
   *  metodene er innenfor et gitt intervall.
   *  Se også checkPositive over.
   */   
  private boolean checkInterval(int param, int from, int to, String name) {
    if (param < from || to < param) {
      String msg = "Parameter " + name + " must be between " + from + " and " + to + "!";
      EGErrorStep step = new EGErrorStep(msg);
      addStep(step);
      return false;
    }  
    
    return true;
  }  
  
  
  /*  Sjekker at brukerprogrammet er startet opp med
   *  kall på launch (fra main).
   */   
  private void checkLaunched() {
    if (!launchedCalled)
      EGCommon.fatalError("EasyGraphics method launch must be called from main!");
  }  
  
  
  /*  Sjekker at en parameter til en av EasyGraphics-
   *  metodene er positiv. For å levere eventuell
   *  feilmelding på riktig tidspunkt (og deretter
   *  avbryte programkjøring), gjøres dette i et 
   *  animasjonssteg.
   */   
  private boolean checkPositive(int param, String name) {
    if (param < 0) {
      String msg = "Parameter " + name + " must be positive!";
      EGErrorStep step = new EGErrorStep(msg);
      addStep(step);
      return false;
    }      
    
    return true;
  }
  
  
  /*  Returnerer tekstlig representasjon av en figurtype.
   */
  private String figTypeToString(Integer figType) {
    String str = "unknown figure";

    if (figType == ARC_TYPE)
      str = "arc";
    else if (figType == CIRCLE_TYPE)
      str = "circle";
    else if (figType == ELLIPSE_TYPE)
      str = "ellipse";
    else if (figType == LINE_TYPE)
      str = "line";
    else if (figType == RECTANGLE_TYPE)
      str = "rectangle";
    else if (figType == STRING_TYPE)
      str = "string";
      
    return str;
  }

  
  /*  Oppretter en instans av applikasjonen. Navnet på applikasjonen 
   *  (programmet som brukeren skriver) avleses fra kallstakken til
   *  den aktive tråden. Det blir sjekket at den kjørbare klassen
   *  (den som deklarerer main) er en subklasse av EasyGraphics.
   *  Ved hjelp av ClassLoader-klassen blir det opprettet et objekt
   *  av den kjørbare klassen (fra navnet på klassen).
   */
  private static EasyGraphics getApp() {
    EasyGraphics obj = null;
    String className = null;
    
    try {
      StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
      int pos = 0;
      boolean found = false;
      while (!found && (pos < stackTraces.length)) {
        StackTraceElement element = stackTraces[pos];
        className = element.getClassName();
        String methodName = element.getMethodName();

        if (methodName.equals("main")) {
          EGCommon.logMessage("Main class: " + className);
          
          ClassLoader loader = ClassLoader.getSystemClassLoader();
          Class theClass  = Class.forName(className, false, loader);
          Class sc = theClass.getSuperclass();
          String scName = sc.getSimpleName();
          
          if (scName.equals("EasyGraphics")) {
            obj = (EasyGraphics) theClass.newInstance();
            found = true;
          }
          else {
            EGCommon.fatalError("Main class is not a subclass (extends) of EasyGraphics");
          }
        }
        else
          pos++;
      }
    }
    catch (ClassNotFoundException e) {
      EGCommon.fatalError("Unable to load class: " + e.toString());
    }
    catch (InstantiationException e) {
      EGCommon.fatalError("Unable to instantiate class: " + e.toString());
    }
    catch (IllegalAccessException e) {
      EGCommon.fatalError("Illegal access: " + e.toString());
    }
    
    if (obj == null)
      EGCommon.fatalError("Main class not found.");
    
    return obj;
  }

  
  /*  Oppretter og viser en sirkelbue.
   */
  private int makeArc(int centerX, int centerY, 
                      int radiusX, int radiusY, 
                      int startAngle, int angleLength,
                      boolean fill) {
    checkLaunched();
    checkPositive(radiusX, "radiusX");
    checkPositive(radiusY, "radiusY");
    EGArc arc = new EGArc(centerX, centerY, radiusX, radiusY, startAngle, angleLength);
    arc.setColor(color);
    arc.setFill(fill);
    EGMakeStep step = new EGMakeStep(arc);    
    addStep(step);
    return nextFigId(ARC_TYPE);
  }
  
  
  /*  Oppretter og viser en sirkel.
   */
  private int makeCircle(int centerX, int centerY, int radius, 
                         boolean fill) {
    checkLaunched();
    checkPositive(radius, "radius");
    EGCircle circle = new EGCircle(centerX, centerY, radius);
    circle.setColor(color);
    circle.setFill(fill);
    EGMakeStep step = new EGMakeStep(circle);    
    addStep(step);
    return nextFigId(CIRCLE_TYPE);
  }
  
  
  /*  Oppretter og viser en ellipse.
   */
  private int makeEllipse(int centerX, int centerY, 
                          int radiusX, int radiusY, 
                          boolean fill) {
    checkLaunched();
    checkPositive(radiusX, "radiusX");
    checkPositive(radiusY, "radiusY");
    EGEllipse ellipse = new EGEllipse(centerX, centerY, radiusX, radiusY);
    ellipse.setColor(color);
    ellipse.setFill(fill);
    EGMakeStep step = new EGMakeStep(ellipse);    
    addStep(step);
    return nextFigId(ELLIPSE_TYPE);
  }
  
  
  /*  Oppretter og viser en linje.
   */
  private int makeLine(int startX, int startY, 
                       int endX, int endY, 
                       boolean fill) {
    checkLaunched();
    EGLine line = new EGLine(startX, startY, endX, endY);
    line.setColor(color);
    line.setFill(fill);
    EGMakeStep step = new EGMakeStep(line);    
    addStep(step);
    return nextFigId(LINE_TYPE);
  }
  
  
  /*  Oppretter og viser et rektangel.
   */
  private int makeRectangle(int minX, int minY, 
                            int width, int height, 
                            boolean fill) {
    checkLaunched();
    checkPositive(width, "width");
    checkPositive(height, "height");
    EGRectangle rectangle = new EGRectangle(minX, minY, width, height);
    rectangle.setColor(color);
    rectangle.setFill(fill);
    EGMakeStep step = new EGMakeStep(rectangle);    
    addStep(step);
    return nextFigId(RECTANGLE_TYPE);
  }
  
  
  /*  Oppretter og viser en tekst.
   */
  private int makeString(int x, int y, String s, boolean fill) {
    checkLaunched();
    EGText str = new EGText(x, y, s, font);
    str.setColor(color);
    str.setFill(fill);
    EGMakeStep step = new EGMakeStep(str);    
    addStep(step);
    return nextFigId(STRING_TYPE);
  }
  
  
  /*  Flytter et geometriobjekt.
   */
  private void moveFigure(int id, int x, int y, Integer figType) {
    checkLaunched();
    checkFigure(id, figType);
    EGMoveStep step = new EGMoveStep(id, x, y);
    addStep(step);
  }
  
  
 
  /*  Returnerer neste figur-id.
   */ 
  private int nextFigId(Integer figType) {
    figTypes.add(figType);
    figCount++;
    return figCount-1;
  }
  
  
  /*  Endrer størrelse på et geometriobjekt.
   */
  private void resize(int id, int w, int h, Integer figType) {
    checkLaunched();
    checkFigure(id, figType);
    EGResizeStep step = new EGResizeStep(id, w, h);    
    addStep(step);
  }

}
