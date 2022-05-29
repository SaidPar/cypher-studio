package com.said.studio.controller;

import com.said.studio.data.ConnectionInfo;
import com.said.studio.model.list.ListAdapterListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashSet;

public class ReadConnectionsAction extends AbstractAction {

  private ListAdapterListModel<ConnectionInfo> connectionListModel;

  public ReadConnectionsAction(ListAdapterListModel<ConnectionInfo> connectionListModel) {
    this.connectionListModel = connectionListModel;

    putValue(NAME, "Read");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ReadConnectionsWorker readConnectionsWorker = new ReadConnectionsWorker(connectionListModel);
    readConnectionsWorker.execute();
  }

  @Override
  public boolean accept(Object sender) {
    return false;
  }
}
