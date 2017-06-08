package easygraphics;

/*  Klassen representerer forflytning av et figur-objekt
 *  langs en rett linje. Endringen blir brutt ned i mange
 *  små steg, slik at man oppnår en animasjonseffekt.
 */
public class EGMoveStep extends EGStep {
  
  private EGFigure fig;
  
  private int id;
  private int x;
  private int y;
  private boolean started;
  
  
  public EGMoveStep(int id, int x, int y) {
    super();
    this.id = id;
    this.x = x;
    this.y = y;
    started = false;
  }
  
  
  public boolean continueStep() {
    fig = EGCanvas.getFig(id);
    
    if (fig.touched())
      return false;
    
    return true;
  }
  
    
  public boolean execute() {
    if (!started) {
      if (fig == null)
        fig = EGCanvas.getFig(id);
      fig.initMove(x, y);
      started = true;
    }
    finished = fig.move();
    return finished;
  }
  
  
  public EGFigure getFig() {
    return fig;
  }
  
  
  public String toString() {
    return "EGMoveStep id=" + id + ", x=" + x + ", y= " + y;
  }
  
}