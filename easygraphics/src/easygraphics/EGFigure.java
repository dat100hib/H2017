package easygraphics;

import java.awt.Color;
import java.awt.Graphics;


/*  Abstrakt superklasse for alle figur-objekt.
 */
public abstract class EGFigure {
  
  // Ved forflytning og reskalering blir endringer
  // mindre enn DELTA piksler utført i ett steg,
  // og ellers i steg på STEP piksler.
  private final static int DELTA = 4;
  private final static int STEP  = 2;
  
  protected int     x;
  protected int     y;
  protected Color   color;
  protected boolean fill;
  
  protected boolean visible;  // Synlig?
  protected boolean touched;  // Endret i siste operasjon?
  
  // Nye koordinater ved forflytning
  private   int     x1;
  private   int     y1;
  
  // Ny størrelse ved reskalering
  private   int     width1;
  private   int     height1;
  
  // Hjelpevariabler brukt ved forflytning/reskalering
  private   int     dx;
  private   int     sx;
  private   int     dy;
  private   int     sy;
  private   int     err;
  
  
  public EGFigure(int x, int y) {
    this.x = x;
    this.y = y;
    color = EGCommon.STD_COLOR;
    fill = false;
    visible = true;
    touched = false;
  }
  
  
  public void draw(Graphics g) {
    g.setColor(color);
    touched = false;
  }
  
  
  public void setX(int x) {
    this.x = x;
  }
  
  
  public int getX() {
    return x;
  }
  
  
  public void setY(int y) {
    this.y = y;
  }
  
  
  public int getY() {
    return y;
  }
  
  
  public void setColor(Color color) {
    this.color = color;
  }
  
  
  public Color getColor() {
    return color;
  }
  
  
  public void setFill(boolean fill) {
    this.fill = fill;
  }
  
  
  public boolean getFill() {
    return fill;
  }
  
  
  public void setVisible(boolean visible) {
    this.visible = visible;
  }
  
  
  
  /* For å effektivisere tegning under animasjon,
   * blir kun den delen av vinduet som er oppdatert
   * tegnet på nytt. Metodene minX, minY, maxX og maxY
   * leverer det omsluttende rektangelet til hvert
   * geometriobjekt, og overlap sjekker om dette
   * rektangelet overlapper med den delen av vinduet
   * som er oppdatert.
   */
   
  public abstract int minX();

  public abstract int minY();

  public abstract int maxX();

  public abstract int maxY();
  
  
  
  // Operasjoner på omsluttende rektangler.
  // Brukes ved endring av størrelse.
  
  public abstract void setWidth(int width);
  
  public abstract int getWidth();
  
  public abstract void setHeight(int height);

  public abstract int getHeight();
  
  
  
  // For å sikre at kode i event-løkka og i hoved-tråden
  // ikke deler figur-objekt, blir det tatt kopier av
  // innholdet i alle slike objekt.
  
  public abstract EGFigure copy();
  
  public void copyColor(Color color) {
    setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
  }
  

  
  //  For å effektivisere tegning blir figur-objekt
  //  som er berørt av et animasjonssteg merket.
  //  Brukes for å utføre flere, "små" steg (på ulike
  //  figur-objekt) i parallell.

  public void touch() {
    touched = true;
  }
  
 
  public boolean touched() {
    return touched;
  }
  
  
  
  // Forflytning langs en rett linje gjøres ved en
  // variant av Bresenham's algoritme. Standardutgaven
  // av denne algoritmen bygger opp en sekvens av punkt
  // med ei løkke. Her blir initieringsdelen av algoritmen
  // utført av initMove, og hvert kall på move finner
  // neste punkt. 
  public void initMove(int x1, int y1) {
    this.x1 = x1;
    this.y1 = y1;
    
    dx = Math.abs(x1 - x);
    dy = Math.abs(y1 - y);
    
    sx = x < x1 ? STEP : -STEP;
    sy = y < y1 ? STEP : -STEP;
    err = (dx > dy ? dx : -dy) / 2;
  }
  
  
  public boolean move() {
    EGCanvas.setUpdateRect(minX(), minY(), maxX(), maxY());
    boolean finished = false;
    
    if (Math.abs(x1 - x) < DELTA && Math.abs(y1 - y) < DELTA) {
      x = x1;
      y = y1;
      finished = true;
    }
      
    if (!finished) {
      int e2 = err;
      if (e2 > -dx) {
        err -= dy;
        x += sx;
      }
      if (e2 < dy) {
        err += dx;
        y += sy;
      }
    }
    
    EGCanvas.setUpdateRect(minX(), minY(), maxX(), maxY());
    touch();
    return finished;
  }
  
  
  // Også reskalering gjøres ved hjelp av Bresenham's algoritme,
  // se kommentar til move over. I stedet for å finne en rett
  // linje fra ett punkt til et annet, finner vi her en måte
  // å skalere et par (bredde,høyde) til et nytt ved like mange
  // endringer langs begge akser.
  //
  // TODO Forflytning og reskalering gjentar nesten samme kode.
  public void initResize(int width1, int height1) {
    this.width1 = width1;
    this.height1 = height1;
    
    dx = Math.abs(width1 - getWidth());
    dy = Math.abs(height1 - getHeight());
      
    sx = getWidth() < width1 ? STEP : -STEP;
    sy = getHeight() < height1 ? STEP : -STEP;
    err = (dx > dy ? dx : -dy) / 2;
  }
  
    
  public boolean resize() {
    EGCanvas.setUpdateRect(minX(), minY(), maxX(), maxY());
    boolean finished = false;
    
    if (Math.abs(width1 - getWidth()) < DELTA 
     && Math.abs(height1 - getHeight()) < DELTA) {
      setWidth(width1);
      setHeight(height1);
      finished = true;
    }
      
    if (!finished) {
      int e2 = err;
      if (e2 > -dx) {
        err -= dy;
        setWidth(getWidth() + sx);
      }
      if (e2 < dy) {
        err += dx;
        setHeight(getHeight() + sy);
      }
    }
    
    EGCanvas.setUpdateRect(minX(), minY(), maxX(), maxY());
    touch();
    return finished;
  }
  
}
