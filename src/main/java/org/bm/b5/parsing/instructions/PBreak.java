package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.instructions.B5Break;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PBreak {

  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    reader.expect(B5Lang.BREAK);

    String loopName = reader.nextToken();

    B5Break brk = new B5Break(block, loopName);

    block.add(brk);
  }

}
