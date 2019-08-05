package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Scope;

import java.util.Collections;
import java.util.List;

public class B5Block extends B5Instr {

  public B5Instr instr;

  public B5Block(B5Scope parent) {
    super(parent);
  }

  @Override
  public void linkCurrent() {
    instr.link();
  }

  @Override
  public void compileCurrent() {
    instr.compile();
  }

  @Override
  public List<B5Instr> getChildren() {
    return Collections.singletonList(instr);
  }
}
