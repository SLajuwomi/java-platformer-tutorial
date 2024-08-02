package main;

public class Game implements Runnable {
  // Create a GameWindow object
  private GameWindow gameWindow;
  // Create GamePanel object
  private GamePanel gamePanel;
  private Thread gameThread;
  private final int FPS_SET = 120;

  public Game() {
    gamePanel = new GamePanel();
    gameWindow = new GameWindow(gamePanel);
    gamePanel.requestFocus();
    startGameLoop();
  }

  private void startGameLoop() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {
    // how long each frame lasts in nanoseconds
    double timePerFrame = 1000000000.0 / FPS_SET;
    long lastFrame = System.nanoTime();
    long now = System.nanoTime();

    now = System.nanoTime();
    while (true) {

      if (now - lastFrame >= timePerFrame) {
        gamePanel.repaint();
        lastFrame = now;
      }
    }
  }
}
