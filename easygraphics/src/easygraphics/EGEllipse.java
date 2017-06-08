package easygraphics;

import java.awt.Graphics;


/*  Et objekt av denne klassen representerer en ellipse.
 */
public class EGEllipse extends EGFigure {

  private int radiusX;
  private int radiusY;
  
  
  public EGEllipse(int x, int y, int radiusX, int radiusY) {
    super(x, y);
    this.radiusX = radiusX;
    this.radiusY = radiusY;
  }

  
  public void draw(Graphics g) {
    if (visible) {
      super.draw(g);
      if (fill)
        g.fillOval(x-radiusX, y-radiusY, 2*radiusX, 2*radiusY);
      else
        g.drawOval(x-radiusX, y-radiusY, 2*radiusX, 2*radiusY);
    }
  }
  
  
  public void setRadiusX(int radiusX) {
    this.radiusX = radiusX;
  }
  
  
  public int getRadiusX() {
    return radiusX;
  }
  
  
  public void setRadiusY(int radiusY) {
    this.radiusY = radiusY;
  }
  
  
  public int getRadiusY() {
    return radiusY;
  }

  
  public int minX() {
    return x-radiusX;
  }
  
  
  public int minY() {
    return y-radiusY;
  }
  
  
  public int maxX() {
    return x+radiusX;
  }
  
  
  public int maxY() {
    return y+radiusY;
  }
  
  
  public void setWidth(int width) {
    this.radiusX = width/2;
  }
  
  
  public int getWidth() {
    return radiusX*2;
  }
  
  
  public void setHeight(int height) {
    this.radiusY = height/2;
  }
  
  
  public int getHeight() {
    return radiusY*2;
  }
  
  
  public EGFigure copy() {
    EGEllipse copy = new EGEllipse(x, y, radiusX, radiusY);
    copy.copyColor(color);
    copy.setFill(fill);
    copy.setVisible(visible);
    return copy;
  }
  
  
  public String toString() {
    return "[EGEllipse x=" + x + ", y=" + y
      + ", radiusX=" + radiusX + ", radiusY=" + radiusY + "]";
  }
  
}
