package org.bm.b5.collections;

import org.bm.b5.B5Element;
import org.bm.b5.B5Scope;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.*;

public class B5Block extends B5List<B5Instr> {

  public final B5Scope parent;

  public B5Block(B5Scope parent) {
    this.parent = parent;
  }

  public void addExit() {
    add(new B5Exit(this));
  }

  public void addDeclare(String name, B5Type type) {
    add(new B5Declare(this, name, type));
  }

  public void addBreak(String loopName) {
    add(new B5Break(this, loopName));
  }

  public B5Call addCall(B5Proc proc) {
    B5Call call = new B5Call(this, proc);
    add(call);
    return call;
  }
}
