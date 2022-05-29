package com.said.studio.model.connections;

import com.said.studio.data.ConnectionInfo;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.List;

public class ConnectionTreeNode implements TreeNode {

  private ConnectionInfo connectionInfo;
  private TreeNode parent;

  private List<TreeNode> databases;

  public ConnectionTreeNode(TreeNode parent, ConnectionInfo connectionInfo) {
    this.parent = parent;
    this.connectionInfo = connectionInfo;
  }

  ConnectionInfo getConnectionInfo() {
    return connectionInfo;
  }

  @Override
  public String toString() {
    return connectionInfo.toString();
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // TreeNode Methods
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  @Override
  public TreeNode getChildAt(int childIndex) {
    return null;
  }

  @Override
  public int getChildCount() {
    return 0;
  }

  @Override
  public TreeNode getParent() {
    return null;
  }

  @Override
  public int getIndex(TreeNode node) {
    return 0;
  }

  @Override
  public boolean getAllowsChildren() {
    return false;
  }

  @Override
  public boolean isLeaf() {
    return false;
  }

  @Override
  public Enumeration<? extends TreeNode> children() {
    return null;
  }
}
