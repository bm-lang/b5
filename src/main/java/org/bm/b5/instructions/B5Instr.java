package org.bm.b5.instructions;

import org.bm.b5.B5Element;
import org.bm.b5.B5Linkable;
import org.bm.b5.B5Program;
import org.bm.b5.B5Scope;
import org.bm.b5.entities.B5Block;

import java.util.Objects;

abstract public class B5Instr extends B5Element implements B5Scope {

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

      current = block.getPrevious(current);
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
}
