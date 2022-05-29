package com.said.studio.view.connections;

import com.said.studio.data.ConnectionInfo;
import com.said.studio.model.connections.ConnectionTreeModel;
import com.said.studio.model.list.ListAdapterListModel;

import javax.swing.*;

public class ConnectionsTab extends JTabbedPane {

  private ConnectionTreeModel connectionTreeModel = new ConnectionTreeModel();

  private JScrollPane connectionsTree = new ConnectionsTree(connectionTreeModel);

  public ConnectionsTab() {
    super();

    this.addTab("Connections", connectionsTree);
  }

  public void setConnectionsList(ListAdapterListModel<ConnectionInfo> connListModel) {
    connectionTreeModel.setListModel(connListModel);
  }
}
