package org.bm.b5.parsing.units.instructions;

import org.bm.b5.B5Program;
import org.bm.b5.entities.B5Block;
import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Declare;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PDeclare {

  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    reader.expect(B5Lang.DECLARE);

    String name = reader.nextToken();

    reader.expect(B5Lang.AS);

    B5Type type = reader.nextType(program);

    B5Declare declare = new B5Declare(block, name, type);

    block.add(declare);
  }

}
