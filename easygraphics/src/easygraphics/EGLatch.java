package easygraphics;

import java.util.concurrent.CountDownLatch;

/*  Klassen brukes for å synkronisere koden i brukerprogrammet
 *  med event-tråden. EasyGraphics tilbyr brukeren en "sekvensiell"
 *  måte å programmere grafikk på, uten å måtte tenke på hendelser.
 *
 *  For å få til dette må vi sørge for at brukerprogrammet (run) av
 *  og til venter på at animasjoner som kjøres som på event-tråden
 *  blir fullført, eller at innputt fra brukeren (getText i EasyGraphics)
 *  er lest inn. Event-tråden vekker da brukerprogrammet opp igjen.
 *  Denne synkroniseringen gjøres ved hjelp av klassen CountDownLatch.
 */
public class EGLatch {

  // Venting mellom hvert forsøk fra event-tråden på
  // å vekke hoved-tråden.
  private static final int PAUSE = 100;
  
  // Vente på animasjon
  private CountDownLatch animationLatch = null;
  
  // Vente på innputt fra brukeren
  private CountDownLatch userLatch = null;
  
  // Vente på initiering av brukergrensesnittet
  private CountDownLatch startupLatch = null;
  
 
 
  /*  Metoden sørger for å sette hoved-tråden "på vent"
   *  til brukergrensesnittet er ferdig opprettet.
   */
  public void awaitStartup() {
    startupLatch = new CountDownLatch(1);
    try {
      startupLatch.await();
    }
    catch (InterruptedException e) {
      EGCommon.logMessage("Interrupt in EGLatch.awaitStartup().");
    }   
  }
  
  
  /*  Metoden sørger for å vekke hoved-tråden når
   *  brukergrensesnittet er ferdig opprettet.
   */
  public void startupFinished() {
    // Hvis startupLatch er null har ikke hoved-tråden
    // rukket å gå inn i "vente-modus".
    while (startupLatch == null)
      pause(PAUSE);
      
    startupLatch.countDown();
    startupLatch = null;
  }

  
  /*  Metoden sørger for å sette hoved-tråden "på vent"
   *  til pågående animasjoner i event-tråden er ferdig
   *  behandlet.
   */
  public void awaitAnimation() {
    animationLatch = new CountDownLatch(1);
    try {
      animationLatch.await();
    }
    catch (InterruptedException e) {
      EGCommon.logMessage("Interrupt in EGLatch.awaitAnimation().");
    }   
  }
  
  
  /*  Metoden sørger for å vekke hoved-tråden når vi
   *  er ferdige med å behandle animasjoner.
   */
  public void animationFinished() {
    // Hvis animationLatch er null har ikke hoved-tråden
    // rukket å gå inn i "vente-modus".
    while (animationLatch == null)
      pause(PAUSE);
      
    animationLatch.countDown();
    animationLatch = null;
  }

  
  /*  Metoden sørger for å sette hoved-tråden "på vent"
   *  til innlesing fra bruker er ferdig.
   */
  public void awaitUser() {
    userLatch = new CountDownLatch(1);
    try {
      userLatch.await();
    }
    catch (InterruptedException e) {
      EGCommon.logMessage("Interrupt in EGLatch.awaitUser().");
    }   
  }
  
  
  /*  Metoden sørger for å vekke hoved-tråden når vi
   *  har lest inndata fra brukeren.
   */
  public void userFinished() {
    // Hvis userLatch er null har ikke hoved-tråden
    // rukket å gå inn i "vente-modus".
    while (userLatch == null)
      pause(PAUSE);
    
    userLatch.countDown();
    userLatch = null;
  }
  
  
  /*  Metoden venter et antall millisekunder.
   */
  private void pause(int ms) {
    try {
      Thread.sleep(ms);
    }
    catch (InterruptedException e) {
      EGCommon.logMessage("EGLatch.pause() interrupted.");
    }
  }

}
