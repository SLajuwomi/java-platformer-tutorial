package main;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
  // JPanel is the picture in the frame
  public GamePanel() {

  }

  // Need a paintCompenent so JPanel can find it
  // JPanel can't draw but the Graphics object can
  public void paintComponent(Graphics g) {
    // call superclass of JPanel through paintComponent
    super.paintComponent(g);

    // (X, Y, WIDTH, HEIGHT)
    g.fillRect(100, 100, 200, 50);
  }
}
