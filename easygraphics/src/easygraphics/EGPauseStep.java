package easygraphics;

/*  Klassen brukes for å legge inn en pause i animasjonen.
 */
public class EGPauseStep extends EGStep {

  private int ms; // Varighet målt i antall millisekunder
  

  public EGPauseStep(int ms) {
    super();
    this.ms = ms;
  }
  
  
  public boolean continueStep() {
    return false;
  }
    
  
  public boolean execute() {
    try {
      Thread.sleep(ms);
    }
    catch (InterruptedException e) {
      EGCommon.logMessage("EGPauseStep.execute() interrupted.");
    }
    finished = true;
    return finished;
  }
  
  
  public String toString() {
    return "EGPauseStep: ms=" + ms;
  }
  
}