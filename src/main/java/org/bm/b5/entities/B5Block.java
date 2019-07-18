package org.bm.b5.entities;

import org.bm.b5.B5Element;
import org.bm.b5.B5Scope;
import org.bm.b5.collections.B5List;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.*;

import java.util.Iterator;

public class B5Block extends B5Element implements Iterable<B5Instr> {

  public final B5Scope parent;

  private final B5List<B5Instr> instrs;

  public B5Block(B5Scope parent) {
    this.parent = parent;
    this.instrs = new B5List<>();
  }

  public void add(B5Instr instr) {
    instrs.add(instr);
  }

  @Override
  public void check() {
    for (B5Instr instr : instrs) {
      instr.check();
    }
  }

  @Override
  public Iterator<B5Instr> iterator() {
    return instrs.iterator();
  }
}
