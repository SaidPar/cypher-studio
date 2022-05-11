package com.said.studio.common;

public enum ConfigProps {

  WORKSPACE_DIR("workspace_directory");

  private final String name;

  ConfigProps(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
