package com.said.studio.view.query.editor;

import com.said.studio.view.query.editor.QueryPanel;

import javax.swing.*;

public class QueryParentPanel extends JSplitPane {

  public QueryParentPanel() {
    super();

    JPanel queryPane = new QueryPanel();
    JPanel resultsPane = setupResultsPane();

    this.setOrientation(SwingConstants.HORIZONTAL);
    this.setLeftComponent(queryPane);
    this.setRightComponent(resultsPane);
  }

  private JPanel setupResultsPane() {
    JPanel resultsPane = new JPanel();

    JTextArea resultsText = new JTextArea(1, 10);
    resultsText.setText("result");

    resultsPane.add(resultsText);

    return resultsPane;
  }
}
