package com.said.studio.model.connections;

import com.said.studio.data.ConnectionInfo;
import com.said.studio.model.list.ListAdapterListModel;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class ConnectionRootTreeNode implements TreeNode {

  private List<TreeNode> connTreeNodes;
  private ListAdapterListModel<ConnectionInfo> connListModel;

  public ConnectionRootTreeNode(ListAdapterListModel<ConnectionInfo> connListModel) {
    this.connListModel = connListModel;
  }

  private List<TreeNode> getConnectionTreeNodes() {
    if (connTreeNodes == null) {
      connTreeNodes = new ArrayList<TreeNode>();

      int size = connListModel.getSize();
      for (int i = 0; i < size; i++) {
        ConnectionInfo connectionInfo = connListModel.getElementAt(i);
        ConnectionTreeNode connectionTreeNode = new ConnectionTreeNode(this, connectionInfo);
        connTreeNodes.add(connectionTreeNode);
      }
    }

    return connTreeNodes;
  }

  void update() {
    this.connTreeNodes = null;
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // TreeNode Implementation
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  @Override
  public TreeNode getChildAt(int childIndex) {
    List<TreeNode> connTreeNodes = getConnectionTreeNodes();
    return connTreeNodes.get(childIndex);
  }

  @Override
  public int getChildCount() {
    return getConnectionTreeNodes().size();
  }

  @Override
  public TreeNode getParent() {
    return null;
  }

  @Override
  public int getIndex(TreeNode node) {
    return getConnectionTreeNodes().indexOf(node);
  }

  @Override
  public boolean getAllowsChildren() {
    return true;
  }

  @Override
  public boolean isLeaf() {
    return false;
  }

  @Override
  public Enumeration<? extends TreeNode> children() {
    return Collections.enumeration(getConnectionTreeNodes());
  }
}
