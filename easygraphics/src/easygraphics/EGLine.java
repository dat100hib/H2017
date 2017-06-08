package easygraphics;

import java.awt.Graphics;


/*  Et objekt av denne klassen representerer et linjestykke.
 */
public class EGLine extends EGFigure {

  private int width;
  private int height;
  
  // En  linje fra (30, 50) til (40, 40) blir representert
  // ved x=30, y=50, width=10, height=-10.
  // Absoluttverdiene til width og height representerer
  // hhv. bredde og høyde, og er negative hvis endepunktet
  // er til venstre / over startpunktet.
  //
  // Brukeren kan dermed opprette linjer ved startpunkt og endepunkt,
  // og flytting kan gjøres ved å oppdatere kun startpunkt (som for
  // øvrige geometriobjekt).
  
  
  public EGLine(int x1, int y1, int x2, int y2) {
    super(x1, y1);
    this.width = x2-x1;
    this.height = y2-y1;
  }

  
  public void draw(Graphics g) {
    if (visible) {
      super.draw(g);
      g.drawLine(x, y, x+width, y+height);
    }
  }
  
  
  public int minX() {
    return Math.min(x, x+width);
  }
  
  
  public int minY() {
    return Math.min(y, y+height);
  }
  
  
  public int maxX() {
    return Math.max(x, x+width);
  }
  
  
  public int maxY() {
    return Math.max(y, y+height);
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
  
  
  
  public EGFigure copy() {
    EGLine copy = new EGLine(x, y, x+width, y+height);
    copy.copyColor(color);
    copy.setFill(fill);
    copy.setVisible(visible);
    return copy;
  }
  
  
  public String toString() {
    return "[EGLine x=" + x + ", y=" + y
      + ", width=" + width + ", height=" + height + "]";
  }
  
}