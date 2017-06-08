package easygraphics;

/*  Klassen brukes for å gjøre et geometriobjekt
 *  synlig/usynlig underveis i en animasjon.
 */
public class EGShowStep extends EGStep {

  private int     id;
  private boolean visibility;
 
 
  public EGShowStep(int id, boolean visibility) {
    super();
    this.id = id;
    this.visibility = visibility;
  }
  
  
  public boolean continueStep() {
    return false;
  }
  
  public boolean execute() {
    EGFigure fig = EGCanvas.getFig(id);
    
    // Avmerk omsluttende rektangel ved ny posisjon
    EGCanvas.setUpdateRect(fig.minX(), fig.minY(), fig.maxX(), fig.maxY());
    
    fig.setVisible(visibility);
    
    fig.touch();
    fig = null;
    
    finished = true;
    return finished;
  }
  
  
  public EGFigure getFig() {
    return EGCanvas.getFig(id);
  }
  
  
  public String toString() {
    return "EGShowStep: id=" + id + ", visibility=" + visibility;
  }
  
}