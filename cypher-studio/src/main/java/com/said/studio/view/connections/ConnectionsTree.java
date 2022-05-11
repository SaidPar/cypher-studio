package com.said.studio.view.connections;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.said.studio.common.ConfigProps;
import com.said.studio.common.ConfigReader;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConnectionsTree extends JScrollPane {

  public ConnectionsTree() {
    super();

    DefaultMutableTreeNode connectionsTreeTop = new DefaultMutableTreeNode();

    List<ConnectionInfo> connections = readConnections();
    for (ConnectionInfo connInfo : connections) {
      addConnection(connectionsTreeTop, connInfo);
    }

    JTree connectionTree = new JTree(connectionsTreeTop);
    this.setViewportView(connectionTree);
  }

  private void addConnection(DefaultMutableTreeNode connTree, ConnectionInfo connInfo) {

    DefaultMutableTreeNode connection = new DefaultMutableTreeNode(connInfo);
    connTree.add(connection);
  }

  private MutableTreeNode scan(File node) {

    DefaultMutableTreeNode ret = new DefaultMutableTreeNode(node.getName());

    if (node.isDirectory()) {
      for (File child: node.listFiles()) {
        ret.add(scan(child));
      }
    }

    return ret;
  }

  private List<ConnectionInfo> readConnections() {

    String workspacePath = ConfigReader.getReader()
      .getPropertyValue(ConfigProps.WORKSPACE_DIR);

    Path connJsonPath = Paths.get(workspacePath, "connections.json");

    Gson gson = new Gson();
    try (Reader reader = Files.newBufferedReader(connJsonPath)) {

      Type type = new TypeToken<List<ConnectionInfo>>(){}.getType();
      return gson.fromJson(reader, type);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return new ArrayList<>();
  }
}
