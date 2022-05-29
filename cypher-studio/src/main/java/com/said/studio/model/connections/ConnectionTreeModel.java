package com.said.studio.model.connections;

import com.said.studio.common.ListEventModel;
import com.said.studio.data.ConnectionInfo;
import com.said.studio.model.list.ListAdapterListModel;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.tree.DefaultTreeModel;

public class ConnectionTreeModel extends DefaultTreeModel {

  private ListAdapterListModel<ConnectionInfo> connectionListModel = new ListAdapterListModel<>();
  private ListModelChangeAdapter listModelChangeAdapter = new ListModelChangeAdapter();
  private ConnectionRootTreeNode connectionRootTreeNode;

  public ConnectionTreeModel() {
    super(null);
  }

  public void setListModel(ListAdapterListModel<ConnectionInfo> connListModel) {
    if (this.connectionListModel != null) {
      this.connectionListModel.removeListDataListener(listModelChangeAdapter);
    }

    this.connectionListModel = connListModel;
    if (connectionListModel != null) {
      connectionListModel.addListDataListener(listModelChangeAdapter);
    }

    connectionRootTreeNode = new ConnectionRootTreeNode(connectionListModel);
    setRoot(connectionRootTreeNode);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Change Adapter
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  private class ListModelChangeAdapter implements ListDataListener {

    public void update() {
      connectionRootTreeNode.update();
      setRoot(connectionRootTreeNode);
    }

    public void intervalAdded(ListDataEvent e) {
      update();
    }

    public void intervalRemoved(ListDataEvent e) {
      update();
    }

    public void contentsChanged(ListDataEvent e) {
      update();
    }

  }
}
