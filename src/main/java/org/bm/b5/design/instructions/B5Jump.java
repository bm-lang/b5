package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Scope;

import java.util.List;
import java.util.function.Consumer;

public class B5Jump extends B5Instr {

  public final String markName;

  public B5Mark linkedMark;

  public B5Jump(B5Scope scope, String markName) {
    super(scope);
    this.markName = markName;
  }

  @Override
  public void linkCurrent() {
    linkedMark = getRoot().findMark(markName);
  }

  @Override
  public void compileCurrent() {

  }

  @Override
  public List<B5Instr> getChildren() {
    return null;
  }

}
