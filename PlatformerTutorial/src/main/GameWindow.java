package main;

import javax.swing.JFrame;

public class GameWindow {
  // JFrame helps create graphical UI
  private JFrame jframe;

  public GameWindow(GamePanel gamePanel) {
    // Create ne JFrame object
    jframe = new JFrame();

    jframe.setSize(400, 400);

    // Stop program after clicking exit button
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.add(gamePanel);
    // Set Visible should be at the bottom
    jframe.setVisible(true);
  }
}
