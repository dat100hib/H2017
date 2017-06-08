package easygraphics;

import java.util.ArrayDeque;

/*  Klassen håndterer operasjonene (steg) som skal bli
 *  utført, typisk tegneoperasjoner. Datastrukturen er
 *  logisk sett en kø, der hoved-tråden setter steg-objekt
 *  inn bakerst og event-tråden henter ut først i køen.
 *  For å redusere synkronisering er datastrukturen egentlig
 *  en kø av køer, med synkroniserte metoder for å legge inn
 *  og ta ut en enkelt kø.
 *
 *  Hvis det ikke er plass til å sette inn en ny kø, vil
 *  hoved-tråden vente. Hvis det ikke er noen kø å hente
 *  vil event-tråden bare ignorere det (se EGCanvas).
 */
public class EGBuffer {

  private ArrayDeque<ArrayDeque<EGStep>> buffer; // Kø av stegkøer
  private ArrayDeque<EGStep> inQueue;            // Kø av steg fra hoved-tråden
  private ArrayDeque<EGStep> outQueue = null;    // Kø av steg til event-tråden
  
  private boolean windowVisible = false;         // Er makeWindow utført?
  
  
  public EGBuffer() {
    buffer = new ArrayDeque<ArrayDeque<EGStep>>(EGCommon.MAX_QUEUES);
    inQueue = new ArrayDeque<EGStep>(EGCommon.INIT_STEPS);
    outQueue = new ArrayDeque<EGStep>();
    windowVisible = false;
  }
  
  
  /*  Legger til en ny stegkø (brukes fra hovedtråden).
   */
  public synchronized boolean addQueue(ArrayDeque<EGStep> q) {
    if (buffer.size() >= EGCommon.MAX_QUEUES-1)
      return false;
    else {
      buffer.offer(q);
      return true;
    }
  }
  
  
  /*  Henter ut første stegkø (brukes fra event-tråden).
   */
  public synchronized ArrayDeque<EGStep> getQueue() {
    ArrayDeque<EGStep> q = null;
    int size = buffer.size();
    if (size > 0)
      q = buffer.poll();
    return q;  
  } 
  
  
  /*  Legger til et nytt animasjonssteg bakerst i inn-køen.
   */
  public void addStep(EGStep step) {  
    if (!windowVisible) {
      if (step instanceof EGWindowStep)
        windowVisible = true;
      else
        EGCommon.fatalError("Method makeWindow must be invoked before all other EasyGraphics methods!");
    }
    
    if (inQueue.size() >= EGCommon.MAX_STEPS) {
      addQueue();
      inQueue = new ArrayDeque<EGStep>(EGCommon.INIT_STEPS);
    }
    inQueue.offer(step);
  }
  

  /*  Legger inn-køen til i bufferet for behandling på event-tråden.
   */
  public void addQueue() {
    boolean success = addQueue(inQueue); // EGCommon.stepBuffer.addQueue(inQueue);
    while (!success) {
      try {
        Thread.sleep(EGCommon.WAIT_TIME);
      }
      catch (InterruptedException e) {
        EGCommon.logMessage("Interrupt in EGBuffer.addQueue().");
      }
      success = addQueue(inQueue); // EGCommon.stepBuffer.addQueue(inQueue);
    }
  }
  
  
  /*  Henter neste steg fra ut-køen.
   */
  public EGStep getStep() {
    EGStep step = null;
    if (outQueue == null)
      outQueue = EGCommon.stepBuffer.getQueue(); 
    if (outQueue != null)
      step = (EGStep) outQueue.poll();
    if (step == null)
      outQueue = null;
    return step;
  }
  
}
