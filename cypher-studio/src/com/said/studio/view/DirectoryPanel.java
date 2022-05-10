package com.said.studio.view;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.io.File;

class DirectoryPanel extends JScrollPane {



  DirectoryPanel() {
    super();

    File workspace = new File("C:\\workspace"); // ToDo: Default workspace? config file?
    MutableTreeNode workspaceTree = scan(workspace);
    JTree fileTree = new JTree(workspaceTree);
    this.setViewportView(fileTree);

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
}
