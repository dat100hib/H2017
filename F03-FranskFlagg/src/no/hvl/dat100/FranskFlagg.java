package no.hvl.dat100;
import easygraphics.*;
/* 
 * Programmet tegner det franske flagget.
 */
 
public class FranskFlagg extends EasyGraphics {
 
  public static void main(String[] args) {
    launch(args);
  }
 
  public void run() {
    makeWindow("Det franske flagget");
 
    setColor(0, 0, 255);  //Blå
    fillRectangle(50, 50, 100, 200);// blå rektangel
    setColor(255, 0, 0); //Rød
    fillRectangle(250, 50, 100, 200);// rød rektangel
    setColor(0, 0, 0);   //hvit 
    drawRectangle(50, 50, 300, 200);
  }
 
}