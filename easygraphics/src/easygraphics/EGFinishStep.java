package easygraphics;

/*  Klassen brukes for å avslutte en animasjon.
 *  Det innebærer å "vekke" hoved-tråden.
 */
public class EGFinishStep extends EGStep {

  public EGFinishStep() {
    super();
  }
  
  
  public boolean continueStep() {
    return false;
  }
  
  
  public boolean execute() {
    EGCommon.latch.animationFinished();
    finished = true;
    return finished;
  }
  
  
  public String toString() {
    return "EGFinishStep";
  }
  
}