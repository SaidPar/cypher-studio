package com.said.studio.common;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

  private static final ConfigReader INSTANCE = new ConfigReader();

  private Properties configProperties;

  private ConfigReader() {
  }

  public static synchronized ConfigReader getReader() {
    return INSTANCE;
  }

  public String getPropertyValue(ConfigProps prop) {
    if (null == configProperties)
      loadConfigProperties();

    return configProperties.getProperty(prop.getName());
  }

  private synchronized void loadConfigProperties() {
    File configFile = new File("config.properties");

    try (InputStream isStream = this.getClass().getClassLoader()
      .getResourceAsStream("config.properties")) {

      configProperties = new Properties();
      configProperties.load(isStream);

    } catch (FileNotFoundException e) {
      e.printStackTrace(); // ToDo: Error Dialog?
    } catch (IOException e) {
      e.printStackTrace();  // ToDo: Error Dialog?
    }
  }
}
