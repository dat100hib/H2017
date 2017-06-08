package easygraphics;

/*  Klassen kjører setningene i brukerprogrammet på en egen tråd.
 */
public class EGRunner implements Runnable {
  
  private EasyGraphics app;  // Applikasjonen
  
   
  public EGRunner(EasyGraphics app) {
    this.app = app;
  }
  
  
  /* Ufører brukerprogrammet og avslutter med å legge
   * de siste, ventende stegene inn på køen.
   */
  public void run() {
    app.run();
    
    // Får utført de siste stegene og avslutter.
    EGCommon.stepBuffer.addStep(new EGFinishStep());
    EGCommon.stepBuffer.addQueue();
    EGCommon.latch.awaitAnimation();
    EGCommon.finish();
  }

}