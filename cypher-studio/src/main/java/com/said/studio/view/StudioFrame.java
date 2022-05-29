package com.said.studio.view;

import com.said.studio.controller.ReadConnectionsAction;
import com.said.studio.data.ConnectionInfo;
import com.said.studio.model.list.ListAdapterListModel;
import com.said.studio.view.connections.ConnectionsTab;
import com.said.studio.view.query.editor.QueryParentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StudioFrame extends JFrame {

  // Models
  private ListAdapterListModel<ConnectionInfo> connListModel = new ListAdapterListModel<>();

  // Views
  private ConnectionsTab connectionsTab = new ConnectionsTab();
  private QueryParentPanel queryParentPanel = new QueryParentPanel();

  // Member Variables
  private Component currentContent;

  public StudioFrame(String title) {
    super(title);

    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(2000, 700);
    this.setLocationRelativeTo(null);

    connectionsTab.setConnectionsList(connListModel);
    setContent(connectionsTab);
    initConnectionsTab();



    JSplitPane splitPane = new JSplitPane(SwingConstants.VERTICAL, connectionsTab, queryParentPanel);
    getContentPane().add(splitPane);

    // Show Frame
//    studioFrame.pack();
//    studioFrame.setVisible(true);
  }

  public void setContent(Component component) {
    Container contentPane = getContentPane();
    if (currentContent != null) {
      contentPane.remove(currentContent);
    }

    contentPane.add(component, BorderLayout.CENTER);
    currentContent = component;
    contentPane.doLayout();
    repaint();
  }

  private void initConnectionsTab() {
    ReadConnectionsAction readConnectionsAction = new ReadConnectionsAction(connListModel);

    readConnectionsAction.addPropertyChangeListener(new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
        int i = 0;
      }
    });

    readConnectionsAction.actionPerformed(new ActionEvent(this, 1, "init"));
  }
}
