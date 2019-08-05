package org.bm.b5.design.collections;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5NamedElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

abstract public class B5Set<T extends B5NamedElement> implements Iterable<T> {

  private final ArrayList<T> list;

  public B5Set() {
    list = new ArrayList<>();
  }

  public int size() {
    return list.size();
  }

  public T get(int index) {
    return list.get(index);
  }

  public T get(String name) {
    synchronized (list) {
      return list.stream()
          .filter(element -> name != null && name.equals(element.name))
          .findFirst()
          .orElse(null);
    }
  }

  public boolean contains(String name) {
    synchronized (list) {
      return list.stream()
          .anyMatch(element -> name != null && name.equals(element.name));
    }
  }

  public void add(T element) {
    synchronized (list) {
      if (element.name == null || element.name.isEmpty()) {
        throw new B5Exception("missing name");
      } else if (contains(element.name)) {
        throw new B5Exception("element is already defined: " + element.name);
      }

      list.add(element);
    }
  }

  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }

  public boolean notEmpty() {
    return list.size() > 0;
  }

  public void compileAll() {
    for (T element : list) {
      element.compile();
    }
  }

  public void linkAll() {
    for (T element : list) {
      element.link();
    }
  }
}
