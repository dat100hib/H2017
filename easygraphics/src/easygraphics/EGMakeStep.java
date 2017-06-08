package easygraphics;

import java.awt.FontMetrics;
import javax.swing.JLabel;


/*  Klassen brukes til å opprette et nytt geometriobjekt,
 *  dvs. tegne det for første gang. Objektet legges til i
 *  listen (se EGCanvas) i konstruktøren, men blir først
 *  synlig når steget blir utført (execute). 
 */
public class EGMakeStep extends EGStep {

  private EGFigure fig;
 
 
  public EGMakeStep(EGFigure fig) {
    super();
    this.fig = fig;
  }
  
  
  public boolean continueStep() {
    return false;
  }
  
  
  public boolean execute() {
    // Oppretter friske kopier av alle figurobjekt.
    // Ser ut til å forbedre effektivitet ved at
    // hovedtråden og event-tråden ikke deler slike objekt.
    EGFigure copyFig = fig.copy();
    EGCanvas.addFig(copyFig);
    
    // Tekstobjekt må spesialbehandles. Bruker fonten
    // for å bestemme bredde og høyde.
    if (copyFig instanceof EGText) {
      EGText txt = (EGText) copyFig;
      JLabel label = new JLabel(); // Kun for å få tak i fonten
      FontMetrics metrics = label.getFontMetrics(txt.getFont());
      txt.setWidth(metrics.stringWidth(txt.getStr()));
      txt.setHeight(metrics.getHeight());
    }
    
    // Avmerk omsluttende rektangel ved ny posisjon
    EGCanvas.setUpdateRect(copyFig.minX(), copyFig.minY(), copyFig.maxX(), copyFig.maxY());
    
    copyFig.touch();
    copyFig.setVisible(true);
    
    fig = null;
    
    finished = true;
    return finished;
  }
  
  
  public EGFigure getFig() {
    return fig;
  }
  
  
  public String toString() {
    String str = "EGMakeStep: fig=";
    if (fig != null)
      str += fig.toString();
    else
      str += "null";
    return str;
  }
  
}