package easygraphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


/*  Klassen representerer tegneflaten. Den har en liste med
 *  figur-objekt og får en kø av operasjoner (steg) for utførelse.
 *  Brukerprogrammet, som kjører på en egen tråd, legger nye
 *  steg (f.eks. en move-operasjon) inn på slutten av køen,
 *  mens tegneflaten, som kjører som del av event-løkka, tar
 *  ut steg fra begynnelsen av den samme køen.
 *
 *  Tegne-operasjonene kontrolleres av en timer (javax.swing.Timer).
 *  Den kaller jevnlig opp en hendelsesmetode (actionPerformed) med noen
 *  millisekunders pause. Hver gang blir ett eller flere steg behandlet
 *  (noen steg blir kun delvis behandlet), og oppdatert figurliste
 *  blir tegnet på nytt.
 */
public class EGCanvas extends JPanel implements ActionListener {
  
  public static  int minX = 0;
  public static  int minY = 0;
  public static  int maxX = EGCommon.STD_WIDTH;
  public static  int maxY = EGCommon.STD_HEIGHT;
  
  private static int width  = EGCommon.STD_WIDTH;
  private static int height = EGCommon.STD_HEIGHT;;
  
  private static Color background = EGCommon.STD_BACKGROUND;
  private static int   speed      = EGCommon.STD_SPEED;
  
  private static Timer timer    = null;
  private static long  delay    = speedToDelay(speed);
  private static long  previous = System.nanoTime();
  
  private static ArrayList<EGFigure> figList  = new ArrayList<EGFigure>();
  private        EGStep              currStep = null;
  
  

  public EGCanvas() {
    setBackground(background);
    initRect();
    previous = System.nanoTime();
    timer = new Timer(0, this);
    timer.start();
  }
   
  
  /*  Vis alle figurene.
   */
  public void paint(Graphics g) {
    super.paintComponent(g);
    setBackground(background); 
    
    // EGCommon.logMessage(figList.toString());
    
    for (EGFigure f : figList) {
      f.draw(g);
    }
  }
  

  /*  Hent steg fra køen for utførelse. For å effektivisere
   *  animasjoner kan flere steg bli utført i ett kall.
   *  Dette vil f.eks. gjelde flere, korte flyttinger av  
   *  forskjellige figurer. Motsatt, blir lengre flyttinger
   *  og større reskaleringer behandlet over flere kall.
   */
  public void actionPerformed(ActionEvent e) {
    // Eventuell kort pause for å styre farten
    if ( keepWaiting() )
      return;
    
    // Initierer "dirty region" 
    // (den delen av vinduet som skal tegnes på nytt)
    initRect();
    
    // Henter og utfører neste steg på køen
    if (currStep == null)
      currStep = EGCommon.stepBuffer.getStep();
    if (currStep == null) {
      return; 
    }
    boolean finishedCurrent = currStep.execute();
    
    // Flere korte forflytninger/reskaleringer blir utført
    // samlet før alle blir tegnet (se EGFigure).
    while (finishedCurrent) {
      currStep = EGCommon.stepBuffer.getStep();
      if (currStep == null)
        finishedCurrent = false;
      else if (currStep.continueStep())
        finishedCurrent = currStep.execute();
      else
        finishedCurrent = false;
    }
    
    // Tegner kun den delen av vinduet som er endret.
    repaint(minX, minY, maxX-minX, maxY-minY); 
    //repaint();
  }


  
  /*  Legg til en figur i figurlisten.
   *
   *  TODO Følgende "avhengighet" bør fjernes:
   *  Figurene får først en (unik) id i hoved-tråden
   *  (se EasyGraphics), og blir tildelt id igjen
   *  ved innsetting nå, gitt ved posisjonen i figurlisten.
   *  Brukerprogrammet kan referere til slik id'er, og
   *  det er avgjørende at figurene blir opprettet i
   *  samme rekkefølge de to stedene i koden.
   *
   *  Mulig løsning: Utvid figur-objekt med id første gang
   *  de opprettes, og la dette definere posisjonen i listen.
   */
  public static void addFig(EGFigure figure) {
    figList.add(figure);
  }
  
  
  /*  Hent figur med gitt id.
   */
  public static EGFigure getFig(int id) {
    if (id < 0 || id > figList.size())
      EGCommon.fatalError("Unknown figure id: " + id);
    return figList.get(id);
  }
  
  
  /*  Sett bakgrunnsfargen.
   */
  public static void setBackgroundColor(Color newwBackground) {
    background = newwBackground;
  }
  

  /*  Sett størrelsen på tegneflaten.
   */ 
  public void setCanvasSize(int width, int height) {
    this.width = width;
    this.height = height;
    Dimension dim = new Dimension(width, height);
    setPreferredSize(dim);
    setMinimumSize(dim);
    setMaximumSize(dim);
  }
  
  
  /*  Objektvariablene (minX, minY, maxX, maxY) tar vare
   *  på den delen av tegneflaten som er endret siden forrige
   *  tegneoperasjon (paintComponent). Dette brukes for å
   *  effektivisere tegning (kun den delen som er endret blir
   *  tegnet på nytt, se kall på repaint i actionPerformed).
   */ 
  public static void setUpdateRect(int minX1, int minY1, int maxX1, int maxY1) {
    minX = Math.min(minX, minX1)-1;
    minY = Math.min(minY, minY1)-1;
    maxX = Math.max(maxX, maxX1)+1;
    maxY = Math.max(maxY, maxY1)+1;
    if (minX < 0)
      minX = 0;
    if (minY < 0)
      minY = 0;
    if (maxX > width)
      maxX = width;
    if (maxY > height)
      maxY = height;
  }
  
  
  /* Initierer rektangelet som er endret. Se setUpdateRect.
   */
  public static void initRect() {
    minX = width;
    minY = height;
    maxX = 0;
    maxY = 0;
  }
  
  
  /*  Sett farten til påfølgende animasjoner.
   */  
  public static void setSpeed(int newSpeed) {
    speed = newSpeed;
    delay = speedToDelay(newSpeed);
    previous = System.nanoTime();
  }
  

  /*  Brukes for å styre farten til animasjoner.
   */    
  private boolean keepWaiting() {
    if (delay == 0)
      return false;
      
    long now = System.nanoTime();
    
    // System.out.println("keepWaiting: " + previous + " - " + delay + " - " + now
    //   + " => " + (now-previous));
    
    if (previous + delay > now) {
        return true;
    }
    
    previous = now;
    return false;
  }
  
  
  /* Oversetter fart til forsinkelse (lav fart = stor forsinkelse).
   */
  private static long speedToDelay(int speed) {
    long nano = 1000000; // 1/1000 s
    return ((speed*-1)+10) * EGCommon.STD_SPEED_SLOWDOWN * nano;
  }
  
}
