package no.hvl.dat100;
/* 
 * Programmet tegner det franske flagget. Bruker
 * kan skalere flagget ved å skrive inn en prosentsats.
 * 100 (prosent) gir "vanlig" størrelse, 50 halv størrelse,
 * 200 dobbel størrelse.
 */
import easygraphics.*;
import static java.lang.Integer.*;

public class FranskFlaggSkaler extends EasyGraphics {
 
  public static void main(String[] args) {
    launch(args);
  }
 
  public void run() {
    makeWindow("Det franske flagget");
 
    String tallTxt = getText("Skalering i prosent:");    
    int str = parseInt(tallTxt);
 
    int vanligBredde = 300, vanligHøyde = 200;
    int bredde = vanligBredde*str/100;
    int høyde = vanligHøyde*str/100;
 
    setColor(0, 0, 255);  //blå
    fillRectangle(50, 50, bredde/3, høyde);
    setColor(255, 0, 0);  //rød
    fillRectangle(50+2*bredde/3, 50, bredde/3, høyde);
    
    //1.
    setColor(0, 0, 0); // svart
    drawRectangle(50, 50, bredde, høyde);
    
    //2    
    /*
    setColor(255, 255,255); // hvit
    fillRectangle(50,50+bredde/3,bredde, høyde);
    */
    
    }
}
