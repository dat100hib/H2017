package no.hvl.dat100;
import easygraphics.*;

import static java.lang.Integer.*;

public class SirkelKvadrater extends EasyGraphics {
 
  public static void main(String[] args) {
    launch(args);
  }
 
  public void run() {
    makeWindow("TegnKvadrat");
 
    // Bør leses inn, sjekk læreboka! 
    int x = 150;
    int y = 150;
    int h = 450;
 
    // Det store kvadratet
    drawRectangle(x, y, h, h); // bredde = høyde
 
    // Den store sirkelen
    int nyH = h/2;           // radius i den ytre sirkel
    int senterX = x + nyH;
    int senterY = y + nyH; 
 
    // Lager gul ring
    setColor(255,255,0); // gul = rød + grønn
    fillCircle(senterX, senterY, nyH);
    // Merker av svart ring i ytterkant
    setColor(0,0,0);  //svart
    drawCircle(senterX, senterY, nyH);
 
 
    // Den lille sirkelen
    int radius = (int)(nyH/Math.sqrt(2));// bruker Pyhagoras 
    setColor(255,255,255); //hvit
    fillCircle(senterX, senterY, radius);
    // Merker av svart ring i ytterkant
    setColor(0,0,0);
    drawCircle(senterX, senterY, radius);
 
    // Det lille kvadratet
    int nyX = x + nyH/2;
    int nyY = y + nyH/2;
    fillRectangle(nyX, nyY, nyH, nyH); //bredde = høyde
 
 
  }
 
}