package com.said.studio.view.connections;

import com.said.studio.model.connections.ConnectionRootTreeNode;
import com.said.studio.model.connections.ConnectionTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class ConnectionTreeCellRenderer extends DefaultTreeCellRenderer {

  private static final Icon root = createImageIcon("connections-root.png");
  private static final Icon connOpen = createImageIcon("connection-open.png");
  private static final Icon connClosed = createImageIcon("connection-closed.png");
  private static final Icon databaseLeaf = createImageIcon("database.png");

  @Override
  public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                boolean leaf, int row, boolean hasFocus) {

    super.getTreeCellRendererComponent(tree, value, selected,expanded, leaf, row, hasFocus);
    if (value instanceof ConnectionRootTreeNode) {
      ConnectionRootTreeNode rootTreeNode = (ConnectionRootTreeNode) value;
      renderConnectionRootNode(rootTreeNode);
    } else if (value instanceof ConnectionTreeNode) {
      ConnectionTreeNode connectionTreeNode = (ConnectionTreeNode) value;
      renderConnectionNode(connectionTreeNode);
    }

//    } else {
//      if (databaseLeaf != null)
//        setIcon(databaseLeaf);
//      else
//        System.err.println("database leaf icon missing. using default");
//
//    }

    return this;
  }

  private void renderConnectionRootNode(ConnectionRootTreeNode rootTreeNode) {
    if (root != null)
      setIcon(root);
    else
      System.err.println("connection root icon missing; using default");

    setText("Connections");
  }

  private void renderConnectionNode(ConnectionTreeNode connectionTreeNode) {
    if (connOpen != null)
      setOpenIcon(connOpen);
    else
      System.err.println("connection open icon missing; using default.");

    if (connClosed != null)
      setClosedIcon(connClosed);
    else
      System.err.println("connection closed icon missing; using default.");

    setText(connectionTreeNode.toString());
  }

  private static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = ConnectionsTree.class.getClassLoader().getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
}
