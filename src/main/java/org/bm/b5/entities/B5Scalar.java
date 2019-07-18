package org.bm.b5.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Program;
import org.bm.b5.B5Scope;

public class B5Scalar extends B5Entity implements B5Scope {

  public final B5Block init;

  public B5Type type;
  public boolean defined;

  public B5Scalar(B5Program parent, String name) {
    super(parent, name);
    this.init = new B5Block(this);
  }

  @Override
  public void check() {
    if (!defined) {
      throw new B5Exception("the scalar " + name + " is not defined");
    }
  }

}
