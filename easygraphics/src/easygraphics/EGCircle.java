package easygraphics;

import java.awt.Graphics;


/*  Et objekt av denne klassen representerer en sirkel.
 */
public class EGCircle extends EGFigure {

  private int radius;
  
  
  public EGCircle(int x, int y, int radius) {
    super(x, y);
    this.radius = radius;
  }
  

  public void draw(Graphics g) {   
    if (visible) {
      super.draw(g);
      if (fill)
        g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
      else
        g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
    }
  }

  
  public void setRadius(int radius) {
    this.radius = radius;
  }
  
  
  public int getRadius() {
    return radius;
  }
  
  
  public int minX() {
    return x-radius;
  }
  
  
  public int minY() {
    return y-radius;
  }
  
  
  public int maxX() {
    return x+radius;
  }
  
  
  public int maxY() {
    return y+radius;
  }
  
  
  public void setWidth(int width) {
    this.radius = width/2;
  }
  
  
  public int getWidth() {
    return radius*2;
  }
  
  
  public void setHeight(int height) {
    this.radius = height/2;
  }
  
  
  public int getHeight() {
    return radius*2;
  }
  
  
  public EGFigure copy() {
    EGCircle copy = new EGCircle(x, y, radius);
    copy.copyColor(color);
    copy.setFill(fill);
    copy.setVisible(visible);
    return copy;
  }
  
  
  public String toString() {
    return "[EGCircle x=" + x + ", y=" + y
      + ", radius=" + radius + "]";
  }
  
}
