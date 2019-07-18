package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.instructions.B5Jump;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PJump {

  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    reader.expect(B5Lang.JUMP);

    String markName = reader.nextToken();

    B5Jump jump = new B5Jump(block, markName);

    block.add(jump);
  }

}
