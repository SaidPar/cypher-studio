package com.said.studio.view.connections;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.said.studio.common.ConfigProps;
import com.said.studio.common.ConfigReader;
import com.said.studio.common.IOUtils;
import com.said.studio.data.ConnectionInfo;
import com.said.studio.data.DatabaseInfo;
import com.said.studio.model.connections.ConnectionTreeModel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.said.studio.common.Constants.CONNECTIONS_JSON;

public class ConnectionsTree extends JScrollPane {

  public ConnectionsTree(ConnectionTreeModel connectionTreeModel) {
    super();

    JTree connectionTree = initConnectionTree(connectionTreeModel);
    this.setViewportView(connectionTree);
  }

  public ConnectionsTree() {
    super();

    DefaultMutableTreeNode connectionsTreeTop = new DefaultMutableTreeNode("Connections");

    // ToDo: Figure out how and where to farm this work to ReadConnectionsWorker... ReadConnectionsAction?
//    List<ConnectionInfo> connections = readConnections();
//    for (ConnectionInfo connInfo : connections) {
//      addConnection(connectionsTreeTop, connInfo);
//    }

//    JTree connectionTree = initConnectionTree(connectionsTreeTop);
//    this.setViewportView(connectionTree);
  }

  private JTree initConnectionTree(ConnectionTreeModel root) {
    JTree connectionTree = new JTree(root);
    DefaultTreeCellRenderer renderer = new ConnectionTreeCellRenderer();
    connectionTree.setCellRenderer(renderer);
    return connectionTree;
  }

  private void addConnection(DefaultMutableTreeNode connTree, ConnectionInfo connInfo) {

    DefaultMutableTreeNode connection = new DefaultMutableTreeNode(connInfo);
    connection.add(new DefaultMutableTreeNode(new DatabaseInfo(connInfo, "")));
    connTree.add(connection);
  }


}
