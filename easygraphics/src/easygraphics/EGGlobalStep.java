package easygraphics;

import java.awt.Color;


/*  Klassen brukes for å styre enten fart eller
 *  bakgrunnsfarge, og vil gjelde for alle påfølgende
 *  operasjoner.
 */
public class EGGlobalStep extends EGStep {

  private int   speed;
  private int   red;
  private int   green;
  private int   blue;
 
 
  public EGGlobalStep(int speed) {
    super();
    this.speed = speed;
    this.red = -1;
    this.green = -1;
    this.blue = -1;
  }
 

  public EGGlobalStep(int red, int green, int blue) {
    super();
    this.red = red;
    this.green = green;
    this.blue = blue;
    speed = -1;
  }
  
  
  public boolean continueStep() {
    return false;
  }
 
  
  public boolean execute() {
    if (speed >= 1 && speed <= 10)
      EGCanvas.setSpeed(speed);
    if (red >= 0 && red <= 255 && green >= 0 && green <= 255 & blue >= 0 && blue <= 255) {
      Color color = new Color(red, green, blue);
      EGCanvas.setBackgroundColor(color);
    }
     
    finished = true;
    return finished;
  }

  
  public String toString() {
    String str = "EGGlobalStep: speed=" + speed + ", backColor=";
    if (red >= 0 && red <= 255 && green >= 0 && green <= 255 & blue >= 0 && blue <= 255)
      str += "(" + red + ", " + blue + ", " + green + ")";
    else
      str += "illegal";
    return str;
  }
  
}