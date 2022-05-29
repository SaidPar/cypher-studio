package com.said.studio.data;

import java.util.List;

public class ConnectionInfo {

  private final String host;
  private final Integer port;
  private final String user;
  private final String password;

  public ConnectionInfo(String host, Integer port, String user, String password) {
    this.host = host;
    this.port = port;
    this.user = user;
    this.password = password;
  }

  public String getHost() {
    return host;
  }

  public Integer getPort() {
    return port;
  }

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return host + ":" + port;
  }
}
