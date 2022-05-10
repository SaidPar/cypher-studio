package com.said.studio;

import com.said.studio.controller.StudioController;
import com.said.studio.model.StudioModel;
import com.said.studio.view.StudioView;

public class App {

  private static final String TITLE = "Cypher Studio";

  public static void main(String[] args) {
    // MVC design pattern
    StudioModel model = new StudioModel();
    StudioView view = new StudioView(TITLE);
    StudioController controller = new StudioController(model, view);
    controller.initController();
  }

}
