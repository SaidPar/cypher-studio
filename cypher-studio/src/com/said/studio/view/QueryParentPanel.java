package com.said.studio.view;

import com.said.studio.view.components.QueryPanel;

import javax.swing.*;

class QueryParentPanel extends JSplitPane {

  QueryParentPanel() {
    super();

    JPanel queryPane = new QueryPanel();
    JPanel resultsPane = setupResultsPane();

    this.setOrientation(SwingConstants.HORIZONTAL);
    this.setLeftComponent(queryPane);
    this.setRightComponent(resultsPane);
  }

  private JPanel setupQueryPane() {
    JPanel queryPane = new JPanel();

    JTextArea queryText = new JTextArea(1, 10);
    queryText.setText("Query Pane");

    queryPane.add(queryText);

    return queryPane;
  }

  private JPanel setupResultsPane() {
    JPanel resultsPane = new JPanel();

    JTextArea resultsText = new JTextArea(1, 10);
    resultsText.setText("result");

    resultsPane.add(resultsText);

    return resultsPane;
  }
}
