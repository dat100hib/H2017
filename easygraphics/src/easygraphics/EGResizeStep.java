package easygraphics;

/*  Klassen endrer størrelsen på et figur-objekt.
 *  Endringen blir brutt ned i mange små steg, slik
 *  at man oppnår en animasjonseffekt.
 */
public class EGResizeStep extends EGStep {

  private EGFigure fig;
  
  private int id;
  private int width;
  private int height;
  private boolean started;
  
  
  public EGResizeStep(int id, int width, int height) {
    super();
    this.id = id;
    this.width = width;
    this.height = height;
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
      fig.initResize(width, height);
      started = true;
    }
    finished = fig.resize();
    return finished;
  }
  
  
  public EGFigure getFig() {
    return fig;
  }
  
  
  public String toString() {
    return "EGResizeStep id=" + id + ", width=" + width + ", height= " + height;
  }
  
}