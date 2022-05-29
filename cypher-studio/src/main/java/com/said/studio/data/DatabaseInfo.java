package com.said.studio.data;

import com.said.studio.view.connections.ConnectionsTab;

public class DatabaseInfo {

  private final ConnectionInfo parentConnection;
  private final String databaseName;

  public DatabaseInfo(ConnectionInfo parentConnection, String databaseName) {
    this.parentConnection = parentConnection;
    this.databaseName = databaseName;
  }

  @Override
  public String toString() {
    return databaseName;
  }
}
