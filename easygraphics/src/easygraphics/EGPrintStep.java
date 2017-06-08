package easygraphics;

/*  Klassen brukes for å gjøre utskrift til
 *  konsollet underveis i en animasjon, slik
 *  at effekten kommer på forventet tidspunkt.
 */
public class EGPrintStep extends EGStep {

  private String msg;
 
 
  public EGPrintStep(String msg) {
    super();
    this.msg = msg;
  }
  
  
  public boolean continueStep() {
    return false;
  }
  
  public boolean execute() {
    System.out.print(msg);
    
    finished = true;
    return finished;
  }
  
 
  public String toString() {
    return "EGPrintStep: msg=" + msg;
  }
  
}