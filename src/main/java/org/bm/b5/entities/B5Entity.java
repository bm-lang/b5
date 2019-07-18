package org.bm.b5.entities;

import org.bm.b5.*;

import java.util.Objects;

abstract public class B5Entity extends B5NamedElement {

  public final B5Program program;

  public B5Entity(B5Program program, String name) {
    super(name);
    this.program = program;
  }

}
