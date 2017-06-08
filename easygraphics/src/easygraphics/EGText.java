package easygraphics;

import java.awt.Font;
import java.awt.Graphics;


/*  Et objekt av denne klassen representerer en (grafisk) tekst.
 */
public class EGText extends EGFigure {

  private String str;
  private Font   font;
  private int    width;
  private int    height;
  
  
  public EGText(int x, int y, String str, Font font) {
    super(x, y);
    this.str = str;
    this.font = font;
  }

  
  public void draw(Graphics g) {
    if (visible) {
      super.draw(g);
      g.setFont(font);
      g.drawString(str, x, y);
    }
  }
  
  
  public String getStr() {
    return str;
  }
  
  
  public Font getFont() {
    return font;
  }
  
  
  public int minX() {
    return x;
  }
  
  
  public int minY() {
    return y-height;
  }
  
  
  public int maxX() {
    return x+width;
  }
  
  
  public int maxY() {
    // Noe av teksten er under fotlinjen (y).
    // Tar i litt for å være helt sikker.
    return y+height;
  }
  
  
  
  // EasyGraphics støtter foreløpig ikke "resizeString".
  // Følgende fire brukes dermed ikke.
  
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
    Font fontCopy = new Font(font.getName(), Font.PLAIN, font.getSize());
    EGText copy = new EGText(x, y, str, fontCopy);
    copy.copyColor(color);
    copy.setFill(fill);
    copy.setVisible(visible);
    return copy;
  }
  
  
  public String toString() {
    return "[EGText x=" + x + ", y=" + y
      + ", str=" + str + "]";
  }
 
}
