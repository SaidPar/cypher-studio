package com.said.studio.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOUtils {

  private IOUtils() {
  }

  public static boolean fileExists(String filePath) {
    File file = new File(filePath);
    return file.exists();
  }

  public static void createFile(String file) throws IOException {
    Path filePath = Path.of(file);
    Files.createFile(filePath);
  }
}
