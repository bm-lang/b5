package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Block;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.design.instructions.B5Nop;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PInstr;

public class PBlock {

  public static B5Block parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.BEGIN);

    B5Block block = new B5Block(scope);

    B5Instr prev = null;

    while(!reader.pull(B5Lang.END)) {
      B5Instr curr = PInstr.parse(reader, program, block);

      if (prev != null) {
        prev.next = curr;
        curr.prev = prev;
      }

      if (block.instr == null) {
        block.instr = curr;
      }

      prev = curr;
    }

    if (block.instr == null) {
      block.instr = new B5Nop(scope);
    }

    return block;
  }

}
