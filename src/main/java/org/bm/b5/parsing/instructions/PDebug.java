package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.instructions.B5Debug;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PDebug {
  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    reader.expect(B5Lang.DEBUG);

    String output = reader.nextToken();

    block.add(new B5Debug(block, output));
  }
}
