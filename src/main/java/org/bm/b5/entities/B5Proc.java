package org.bm.b5.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Program;
import org.bm.b5.B5Scope;
import org.bm.b5.collections.B5Params;

public class B5Proc extends B5Entity implements B5Scope {

  public final B5Params params;
  public final B5Block body;

  public boolean defined;
  public B5Type returnType;

  public B5Proc(B5Program program, String name) {
    super(program, name);
    this.params = new B5Params(this);
    this.body = new B5Block(this);
  }

  @Override
  public void check() {
    if (!defined) {
      throw new B5Exception("the proc " + name + " is not defined");
    }
  }
}
