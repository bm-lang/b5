package org.bm.b5.entities;

import org.bm.b5.*;
import org.bm.b5.instructions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class B5Block extends B5Element implements B5Scope, Iterable<B5Instr> {

  public final B5Scope parent;

  private final ArrayList<B5Instr> instrs;

  public B5Block(B5Scope parent) {
    this.parent = parent;
    this.instrs = new ArrayList<>();
  }

  public void add(B5Instr instr) {
    instrs.add(instr);
  }

  public B5Instr getPrevious(B5Instr instr) {
    int index = instrs.indexOf(instr);

    if (index == -1) {
      throw new B5Exception("instr is not part of this block");
    }
    else if (index == 0) {
      return null;
    }

    return instrs.get(index - 1);
  }

  @Override
  public void checkDefinition() {
    for (B5Instr instr : instrs) {
      instr.checkDefinition();
    }
  }

  @Override
  public void linkReferences() {
    for (B5Instr instr : instrs) {
      instr.linkReferences();
    }
  }

  @Override
  public B5Linkable findLinkable(String name) {
    return parent.findLinkable(name);
  }

  @Override
  public B5Block getContextBlock() {
    return this;
  }

  @Override
  public B5Program getProgram() {
    return parent.getProgram();
  }

  @Override
  public Iterator<B5Instr> iterator() {
    return instrs.iterator();
  }

  public B5Mark findContextMark(String name) {
    for (B5Instr instr : instrs) {
      if (instr instanceof B5Mark) {
        B5Mark mark = (B5Mark)instr;

        if (Objects.equals(mark.name, name)) {
          return mark;
        }
      }
    }

    B5Block parentBlock = parent.getContextBlock();

    if (parentBlock == null) {
      throw new B5Exception("mark not found: " + name);
    }

    return parentBlock.findContextMark(name);
  }

  public B5Loop findContextLoop(String name) {
    for (B5Instr instr : instrs) {
      if (instr instanceof B5Loop) {
        B5Loop loop = (B5Loop)instr;

        if (Objects.equals(loop.name, name)) {
          return loop;
        }
      }
    }

    B5Block parentBlock = parent.getContextBlock();

    if (parentBlock == null) {
      throw new B5Exception("loop not found: " + name);
    }

    return parentBlock.findContextLoop(name);
  }
}
