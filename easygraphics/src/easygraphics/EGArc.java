package easygraphics;

import java.awt.Graphics;


/*  Et objekt av denne klassen representerer en sirkelbue
 *  (uten fyll), eller et "kakestykke" (med fyll).
 */
public class EGArc extends EGFigure {

  private int radiusX;
  private int radiusY;
  private int startAngle;
  private int angleLength;
  
  
  public EGArc(int x, int y,
               int radiusX, int radiusY, 
               int startAngle, int angleLength) {
    super(x, y);
    this.radiusX = radiusX;
    this.radiusY = radiusY;
    this.startAngle = startAngle;
    this.angleLength = angleLength;
  }
  

  public void draw(Graphics g) {
    if (visible) {
      super.draw(g);
      if (fill)
        g.fillArc(x-radiusX,  y-radiusY,
                  2*radiusX,  2*radiusY, 
                  startAngle, angleLength);
      else
        g.drawArc(x-radiusX,  y-radiusY, 
                  2*radiusX,  2*radiusY, 
                  startAngle, angleLength);
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
    EGArc copy = new EGArc(x, y, radiusX, radiusY, startAngle, angleLength);
    copy.copyColor(color);
    copy.setFill(fill);
    copy.setVisible(visible);
    return copy;
  }
  

  public String toString() {
    return "[EGArc x=" + x + ", y=" + y
      + ", radiusX=" + radiusX + ", radiusY=" + radiusY
      + ", startAngle= " + startAngle + ", angleLength" + angleLength + "]";
  }
  
}
