package org.bm.b5.design.collections;

import org.bm.b5.design.B5Element;

import java.util.ArrayList;
import java.util.Iterator;

public class B5List<T extends B5Element> implements Iterable<T> {

  private final ArrayList<T> list;

  public B5List() {
    this.list = new ArrayList<>();
  }

  public void add(T item) {
    list.add(item);
  }

  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }
}
