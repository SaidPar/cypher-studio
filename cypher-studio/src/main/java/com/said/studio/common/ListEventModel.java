package com.said.studio.common;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEventModel<E> extends AbstractListModel<E> {

  private List<E> backingList = new ArrayList<E>();

  public void setList(List<E> list) {
    this.backingList.clear();
    this.backingList.addAll(list);
    fireListDataChanged();
  }

  public void clear() {
    this.backingList.clear();
    fireListDataChanged();
  }

  private void fireListDataChanged() {
    fireContentsChanged(this, 0, Math.max(backingList.size() - 1, 0));
  }

  public void addAll(List<E> elements) {
    if (this.backingList.addAll(elements)) {
      fireIntervalAdded(elements.size());
    }
  }

  protected void fireIntervalAdded(int elementCOunt) {
    int index0 = backingList.size() - elementCOunt;
    fireIntervalAdded(this, Math.max(0, index0),
      Math.max(0, backingList.size() - 1));
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // AbstractListModel Interface Methods
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  @Override
  public int getSize() {
    return backingList.size();
  }

  @Override
  public E getElementAt(int index) {
    return backingList.get(index);
  }

  public List<E> getList() {
    return Collections.unmodifiableList(backingList);
  }

  public int indexOf(E element) {
    return backingList.indexOf(element);
  }
}
