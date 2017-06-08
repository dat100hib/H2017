package easygraphics;

import java.awt.Graphics;


/*  Et objekt av denne klassen representerer et rektangel.
 */
public class EGRectangle extends EGFigure {

  private int width;
  private int height;
  
  
  public EGRectangle(int x, int y, int width, int height) {
    super(x, y);
    this.width = width;
    this.height = height;
  }

  
  public void draw(Graphics g) {
    if (visible) {
      super.draw(g);
      if (fill)
        g.fillRect(x, y, width, height);
      else
        g.drawRect(x, y, width, height);
    }
  }


  public void setWidth(int width) {
    this.width = width;
  }
  
  
  public int getWidth() {
    return width;
  }
  
  
  public void setHeight(int height) {
    this.height = height;
  }
  
  
  public int getHeight() {
    return height;
  }
  
  
  public int minX() {
    return x;
  }
  
  
  public int minY() {
    return y;
  }
  
  
  public int maxX() {
    return x+width;
  }
  
  
  public int maxY() {
    return y+height;
  }
  
  
  public EGFigure copy() {
    EGRectangle copy = new EGRectangle(x, y, width, height);
    copy.copyColor(color);
    copy.setFill(fill);
    copy.setVisible(visible);
    return copy;
  }
  
  
  public String toString() {
    return "[EGRectangle x=" + x + ", y=" + y
      + ", width=" + width + ", height=" + height + "]";
  }
  
}