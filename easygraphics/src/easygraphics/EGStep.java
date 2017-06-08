package easygraphics;

/*  Abstrakt superklasse for alle oppgaver (steg).
 *  Hovedtråden legger slike steg inn på en kø, som
 *  event-tråden plukker fra, og utfører etter tur.
 *
 */
public abstract class EGStep {
          
  // Noen steg (forflytninger/reskaleringer) blir
  // brutt ned i flere "mini-steg".
  protected boolean finished;        // Avsluttet?
    

  public EGStep() {
    finished = false;
  }
  
  
  public boolean finished() {
    return finished;
  }
  
  
  /*  Svært korte/små forflytninger/reskaleringer på
   *  ulike objekt blir utført i parallell. Denne metoden
   *  returnerer true for slike steg.
   */
  public abstract boolean continueStep();
  
 
  /*  Utfører steget og returnerer true hvis ferdig.
   */
  public abstract boolean execute();
  
  
  /*  Subklasser som er knyttet til et bestemt figur-objekt,
   *  f.eks. en flytting, overstyrer denne metoden.
   */
  public EGFigure getFig() {
    return null;
  }

}
