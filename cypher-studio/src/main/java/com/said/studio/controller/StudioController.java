package com.said.studio.controller;

import com.said.studio.model.StudioModel;
import com.said.studio.view.StudioFrame;


public class StudioController {

  private StudioModel studioModel;
  private StudioFrame studioFrame;

  public StudioController(StudioModel model, StudioFrame view) {
    this.studioModel = model;
    this.studioFrame = view;
    initView();
  }

  public void initController() {
    // add action listeners

  }

  private void initView() {
    // init
  }



}
