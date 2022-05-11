package com.said.studio.view.connections;

import javax.swing.*;

public class ConnectionsTab extends JTabbedPane {

  public ConnectionsTab() {
    super();

    JComponent connectionsTree = new ConnectionsTree();
    this.addTab("Connections", connectionsTree);
  }

}
