package no.hvl.dat100;
 
import static java.lang.Integer.*; 
import static java.lang.Math.*; 
import static javax.swing.JOptionPane.*;
 
public class Tippekupong {
 
  public static void main(String[] args) { 
    String antTxt = showInputDialog("Antall kamper:");
    int antKamper = parseInt(antTxt);
 
    int antRekker = (int) pow(3, antKamper);     
 
    String ut = "Antall rekker med " + antKamper +
                " kamper: " + antRekker;
    showMessageDialog(null, ut);
  }
 
}
