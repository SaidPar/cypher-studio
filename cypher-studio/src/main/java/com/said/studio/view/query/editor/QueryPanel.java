package com.said.studio.view.query.editor;

import javax.swing.*;
import java.awt.*;

public class QueryPanel extends JPanel {

  protected JTextArea textArea;

  public QueryPanel() {
    super(new GridBagLayout());

    textArea = new JTextArea(5, 20);
    textArea.setEditable(true);
    JScrollPane scrollPane = new JScrollPane(textArea);

    // add components to this panel
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.fill = GridBagConstraints.BOTH;
    constraints.weightx = 1.0;
    constraints.weighty = 1.0;

    add(scrollPane, constraints);
  }
}
