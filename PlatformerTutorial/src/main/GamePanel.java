package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
  private MouseInputs mouseInputs;
  private int xDelta = 100, yDelta = 100;

  // JPanel is the picture in the frame
  public GamePanel() {
    mouseInputs = new MouseInputs(this);
    addKeyListener(new KeyboardInputs(this));
    addMouseListener(mouseInputs);
    addMouseMotionListener(mouseInputs);
  }

  // Doesn't work without a game loop
  // to repaint the rectangle
  // repaint();
  public void changeXDelta(int value) {
    this.xDelta += value;
    repaint();
  }

  public void changeYDelta(int value) {
    this.yDelta += value;
    repaint();
  }

  public void setRectPos(int x, int y) {
    this.xDelta = x;
    this.yDelta = y;
    repaint();
  }

  // Need a paintCompenent so JPanel can find it
  // JPanel can't draw but the Graphics object can
  public void paintComponent(Graphics g) {
    // call superclass of JPanel through paintComponent
    super.paintComponent(g);

    // (X, Y, WIDTH, HEIGHT)
    g.fillRect(xDelta, yDelta, 200, 50);
  }
}
