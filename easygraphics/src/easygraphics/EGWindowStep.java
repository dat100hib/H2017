package easygraphics;

import java.awt.*;
import javax.swing.*;

/*  Klassen brukes til å opprette opprette det grafiske
 *  vinduet. Dette må alltid være det første steget
 *  (kall på makeWindow må stå først i run).
 */
public class EGWindowStep extends EGStep {
 
  private EGGui    gui;
  private String   title;
  private int      width;
  private int      height;
  
  
  public EGWindowStep(EGGui gui, String title, int width, int height) {
    super();
    this.title = title;
    this.width = width;
    this.height = height;
    this.gui = gui;
  }
  
  
  public boolean continueStep() {
    return false;
  }
  
  
  public boolean execute() {
    gui.show(title, width, height);
    finished = true;
    return finished;
  }
  
  
  public String toString() {
    return "EGWindowStep: title=" + title
      + ", width=" + width + ", height=" + height;
  }
  
}