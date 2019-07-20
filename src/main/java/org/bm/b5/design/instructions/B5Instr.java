package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Element;
import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Block;

import java.util.Objects;
import java.util.function.Consumer;

abstract public class B5Instr extends B5Element implements B5Scope {

  public abstract void walk(Consumer<B5Instr> consumer);

  public final B5Block block;

  public B5Instr(B5Block block) {
    this.block = block;
  }

  public B5Linkable findLinkable(String name) {
    B5Instr current = this;

    while (current != null) {
      if (current instanceof B5Linkable) {
        B5Linkable linkable = (B5Linkable) current;

        if (Objects.equals(name, linkable.getName())) {
          return linkable;
        }
      }

      current = block.getLocalPrevious(current);
    }

    return block.findLinkable(name);
  }

  @Override
  public B5Block getContextBlock() {
    return block;
  }

  @Override
  public B5Program getProgram() {
    return block.getProgram();
  }

  public B5Instr next() {
    return block.getLocalNext(this);
  }
}
