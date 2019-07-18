package org.bm.b5.design.entities;

import org.bm.b5.*;
import org.bm.b5.design.B5Element;
import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.design.instructions.B5Loop;
import org.bm.b5.design.instructions.B5Mark;
import org.bm.b5.design.instructions.B5Return;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

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
  public void checkTypes() {
    for (B5Instr instr : instrs) {
      instr.checkTypes();
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

  public B5Type getReturnType() {
    ArrayList<B5Type> returnTypes = new ArrayList<>();

    walk(instr -> {
      if (instr instanceof B5Return) {
        B5Return ret = (B5Return)instr;
        B5Type retType = ret.value.findType();

        returnTypes.add(retType);
      }
    });

    if (returnTypes.isEmpty()) {
      return null;
    }

    return getProgram().findMostGeneralType(returnTypes);
  }

  public void walk(Consumer<B5Instr> consumer) {
    for (B5Instr instr : instrs) {
      consumer.accept(instr);

      instr.walk(consumer);
    }
  }
}