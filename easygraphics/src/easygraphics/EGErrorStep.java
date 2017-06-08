package easygraphics;

/*  Klassen brukes for å avbryte programkjøringen.
 *  Hvis brukerprogrammet kaller EasyGraphics-metoder
 *  med ulovlige parametre skal programkjøring avbrytes.
 *  For at dette skal skje på korrekt tidspunkt i
 *  forhold til en animasjon, blir operasjonen lagt inn
 *  som et steg i køen på vanlig måte.
 */
public class EGErrorStep extends EGStep {

  private String msg; // Feilmelding
  

  public EGErrorStep(String msg) {
    super();
    this.msg = msg;
  }
  
  
  public boolean continueStep() {
    return false;
  }
  
  
  public boolean execute() {
    EGCommon.fatalError(msg);
    return true;
  }
  
  
  public String toString() {
    return "EGErrorStep: msg=" + msg;
  }
  
}