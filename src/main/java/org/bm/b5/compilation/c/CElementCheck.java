package org.bm.b5.compilation.c;

import org.bm.b5.design.B5Element;

import java.util.HashSet;

public class CElementCheck {

  private final HashSet<B5Element> control;

  public CElementCheck() {
    control = new HashSet<>();
  }

  public boolean check(B5Element element) {
    return control.contains(element);
  }

  public boolean register(B5Element element) {
    return control.add(element);
  }

}
