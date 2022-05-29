package com.said.studio.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.said.studio.common.ConfigProps;
import com.said.studio.common.ConfigReader;
import com.said.studio.common.IOUtils;
import com.said.studio.data.ConnectionInfo;
import com.said.studio.model.list.ListAdapterListModel;

import javax.swing.*;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.said.studio.common.Constants.CONNECTIONS_JSON;

public class ReadConnectionsWorker extends SwingWorker<List<ConnectionInfo>, ConnectionInfo> {

  private ListAdapterListModel<ConnectionInfo> connectionListModel;

  public ReadConnectionsWorker(ListAdapterListModel<ConnectionInfo> connInfoListModel) {
    this.connectionListModel = connInfoListModel;
  }

  @Override
  protected List<ConnectionInfo> doInBackground() throws Exception {
    connectionListModel.clear();
    List<ConnectionInfo> connections = readConnections();
    publish(connections.toArray(new ConnectionInfo[0]));
    return connections;
  }

  @Override
  protected void process(List<ConnectionInfo> chunks) {
    connectionListModel.addAll(readConnections());
  }

  private List<ConnectionInfo> readConnections() {
    try {
      String workspacePath = ConfigReader.getReader()
        .getPropertyValue(ConfigProps.WORKSPACE_DIR);

      Path connJsonPath = Paths.get(workspacePath, CONNECTIONS_JSON);
      if (!IOUtils.fileExists(connJsonPath.toString()))
        IOUtils.createFile(connJsonPath.toString());

      Gson gson = new Gson();
      try (Reader reader = Files.newBufferedReader(connJsonPath)) {

        Type type = new TypeToken<List<ConnectionInfo>>(){}.getType();
        List<ConnectionInfo> connList = gson.fromJson(reader, type);
        return connList == null ? new ArrayList<>() : connList;

      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new ArrayList<>();
  }
}
