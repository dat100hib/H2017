package easygraphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/*  Klassen oppretter brukergrensesnittet på event-tråden,
 *  og håndterer inndata fra bruker.
 */
class EGGui implements Runnable, ActionListener {

  private final String STD_TITLE = "EasyGraphics";
  
  private final Font   inputFont = new Font("Arial", Font.PLAIN, 18);
  private final String inputMsg  = "Inndata:";
  
  private EasyGraphics app;      // Hovedvinduet
  
  private JLabel       message;  // Ledetekst for inndatafelt
  private JTextField   line;     // Inndatafelt
  private EGCanvas     canvas;   // Tegneområde
  private String       response; // Respons fra brukeren
  
  
  public EGGui(EasyGraphics app) {
    this.app = app;
  }
  
  
  /* Oppretter brukergrensesnittet og gir beskjed om
   * at setningene i brukerprogrammet kan startes opp.
   */
  public void run() {
    makeGUI();
    EGCommon.latch.startupFinished();
  }
  
  
  public JLabel getMessage() {
    return message;
  }
  
  
  public JTextField getLine() {
    return line;
  }
  
  
  public String getResponse() {
    return response;
  }
  
  
  public void listenModus(boolean modus) {
    if (modus)
      line.addActionListener(this);
    else
      line.removeActionListener(this);
  }
  
  
  public void show(String title, int width, int height) {
    canvas.setCanvasSize(width, height);
    app.setTitle(title);
    app.pack();
    app.setResizable(false);
    app.setVisible(true);
  }
  
  
  public void actionPerformed(ActionEvent e) {
    // Har fanget inndata og avslutter lytting i denne omgangen
    listenModus(false);
    
    response = line.getText().trim();
    message.setText(inputMsg);
    line.setText("");
    line.getCaret().setVisible(false);
    line.setEditable(false);

    EGCommon.latch.userFinished();
    
    // Tråden for hovedprogrammet ble satt "på vent"
    // i påvente av inndata, og kan nå fortsette.
  }
  
  
  private void makeGUI() {
    app.setTitle(STD_TITLE);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
    message = new JLabel(inputMsg, SwingConstants.CENTER);
    message.setFont(inputFont);
    
    line = new JTextField(20);
    line.setFont(inputFont);
    line.setBorder(new LineBorder(Color.GRAY));
    line.getCaret().setVisible(false);
    line.setEditable(false);
    
    JPanel topPanel = new JPanel(new GridLayout(2, 1));
    JPanel messagePanel = new JPanel();
    messagePanel.add(message);
    JPanel linePanel = new JPanel();
    linePanel.add(line);
    topPanel.add(messagePanel);
    topPanel.add(linePanel);
    app.add(topPanel, BorderLayout.NORTH);
          
    JPanel centerPanel = new JPanel();
    JPanel canvasPanel = new JPanel(new GridLayout(1, 1, 1, 1));
    canvasPanel.setBackground(Color.GRAY);
    canvasPanel.setBorder(new MatteBorder(1, 1, 1, 1, Color.GRAY));
    canvas = new EGCanvas();
    canvasPanel.add(canvas);
    centerPanel.add(canvasPanel);
    app.add(centerPanel, BorderLayout.CENTER);
  }
}