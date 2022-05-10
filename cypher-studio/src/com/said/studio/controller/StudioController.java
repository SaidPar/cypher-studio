package com.said.studio.controller;

import com.said.studio.model.StudioModel;
import com.said.studio.view.StudioView;


public class StudioController {

  private StudioModel studioModel;
  private StudioView studioView;

  public StudioController(StudioModel model, StudioView view) {
    this.studioModel = model;
    this.studioView = view;
    initView();
  }

  public void initController() {
    // add action listeners
  }

  private void initView() {
    // init
  }



}
