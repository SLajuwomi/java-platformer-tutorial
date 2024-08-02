package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
  private MouseInputs mouseInputs;
  private float xDelta = 100, yDelta = 100;
  private float xDir = 0.003f, yDir = 0.003f;
  private int frames = 0;
  private long lastCheck = 0;
  private Color color = new Color(150, 255, 150);
  private Random random;

  // JPanel is the picture in the frame
  public GamePanel() {
    random = new Random();
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

  }

  public void changeYDelta(int value) {
    this.yDelta += value;

  }

  public void setRectPos(int x, int y) {
    this.xDelta = x;
    this.yDelta = y;

  }

  // Need a paintCompenent so JPanel can find it
  // JPanel can't draw but the Graphics object can
  public void paintComponent(Graphics g) {
    // call superclass of JPanel through paintComponent
    super.paintComponent(g);

    updateRectangle();

    g.setColor(color);
    // (X, Y, WIDTH, HEIGHT)
    g.fillRect((int) xDelta, (int) yDelta, 200, 50);

    frames++;
    // If one second have passed since the last fps check
    // we do a new fps check
    // Save the new FPS check ast the lastFps and repeat
    if (System.currentTimeMillis() - lastCheck >= 1000) {
      lastCheck = System.currentTimeMillis();
      System.out.println("FPS: " + frames);
      frames = 0;
    }

  }

  private void updateRectangle() {
    xDelta += xDir;
    if (xDelta > 400 || xDelta < 0) {
      xDir *= -1;
      color = getRndColor();
    }

    yDelta += yDir;
    if (yDelta > 400 || yDelta < 0) {
      yDir *= -1;
      color = getRndColor();
    }
  }

  private Color getRndColor() {
    int r = random.nextInt(255);
    int g = random.nextInt(255);
    int b = random.nextInt(255);

    return new Color(r, g, b);
  }
}
