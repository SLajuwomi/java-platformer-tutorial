package main;

public class Game {
  // Create a GameWindow object
  private GameWindow gameWindow;
  // Create GamePanel object
  private GamePanel gamePanel;

  public Game() {
    gamePanel = new GamePanel();
    gameWindow = new GameWindow(gamePanel);
    gamePanel.requestFocus();
  }
}
