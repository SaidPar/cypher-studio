package com.said.studio.view;

import com.said.studio.view.connections.ConnectionsTab;
import com.said.studio.view.connections.ConnectionsTree;
import com.said.studio.view.query.editor.QueryParentPanel;

import javax.swing.*;
import java.awt.*;

public class StudioFrame {

  private final ConnectionsTab connectionsTab;
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
    connectionsTab = new ConnectionsTab();
    queryParentPanel = new QueryParentPanel();

    JSplitPane splitPane = new JSplitPane(SwingConstants.VERTICAL, connectionsTab, queryParentPanel);

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
