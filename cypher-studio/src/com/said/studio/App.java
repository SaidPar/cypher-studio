package com.said.studio;

import com.said.studio.controller.StudioController;
import com.said.studio.model.StudioModel;
import com.said.studio.view.StudioFrame;

public class App {

  private static final String TITLE = "Cypher Studio";

  public static void main(String[] args) {
    // MVC design pattern
    StudioModel model = new StudioModel();
    StudioFrame view = new StudioFrame(TITLE);
    StudioController controller = new StudioController(model, view);

    // Schedule a job for the event dispatch thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(() -> {
      controller.initController();
    });
  }

}
