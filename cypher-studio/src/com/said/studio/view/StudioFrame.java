package com.said.studio.view;

import javax.swing.*;
import java.awt.*;

public class StudioFrame {

  private final DirectoryPanel directoryPanel;
  private final QueryParentPanel queryParentPanel;

  private JFrame studioFrame;

  public StudioFrame(String title) {
    // Parent Frame
    studioFrame = new JFrame(title);
    studioFrame.getContentPane().setLayout(new BorderLayout());
    studioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    studioFrame.setSize(1000, 120);
    studioFrame.setLocationRelativeTo(null);

    // Panes
    directoryPanel = new DirectoryPanel();
    queryParentPanel = new QueryParentPanel();

    JSplitPane splitPane = new JSplitPane(SwingConstants.VERTICAL, directoryPanel, queryParentPanel);

    studioFrame.add(splitPane);
    studioFrame.setSize(500, 500);

    // Show Frame
    studioFrame.pack();
    studioFrame.setVisible(true);
  }

  public JFrame getFrame() {
    return studioFrame;
  }

  public void setFrame(JFrame frame) {
    this.studioFrame = frame;
  }

}
