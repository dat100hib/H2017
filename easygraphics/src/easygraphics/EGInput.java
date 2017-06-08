package easygraphics;

import javax.swing.JLabel;
import javax.swing.JTextField;


/*  Klassen brukes for å klargjøre for ny innlesing fra brukeren.
 */
public class EGInput implements Runnable {
 
  private EGGui  gui;
  private String msg;
 
 
  public EGInput(EGGui gui, String msg) {
    super();
    this.gui = gui;
    this.msg = msg;
  }
 
  
  public void run() {
    JLabel lbl = gui.getMessage();
    JTextField txt = gui.getLine();
    
    lbl.setText(msg);
    txt.setText("");
    txt.grabFocus();
    txt.getCaret().setVisible(true);
    txt.setEditable(true);
    txt.grabFocus();
    
    // Starter lytting på tekstfeltet
    gui.listenModus(true);
  }
  
  
  public String toString() {
    return "EGInput: msg=" + msg;
  }
  
}