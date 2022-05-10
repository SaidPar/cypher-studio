package com.said.studio.view;

import javax.swing.*;
import java.awt.*;

public class StudioView {

  private JFrame studioFrame;

  public StudioView(String title) {
    studioFrame = new JFrame(title);
    studioFrame.getContentPane().setLayout(new BorderLayout());
    studioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    studioFrame.setSize(500, 120);
    studioFrame.setLocationRelativeTo(null);
    studioFrame.setVisible(true);
  }

  public JFrame getFrame() {
    return studioFrame;
  }
  public void setFrame(JFrame frame) {
    this.studioFrame = frame;
  }
}
