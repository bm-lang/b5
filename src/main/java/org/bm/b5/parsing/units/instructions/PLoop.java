package org.bm.b5.parsing.units.instructions;

import org.bm.b5.B5Program;
import org.bm.b5.entities.B5Block;
import org.bm.b5.instructions.B5Loop;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PBlock;

public class PLoop {
  
  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    reader.expect(B5Lang.LOOP);

    String name = reader.nextToken();

    B5Loop loop = new B5Loop(block, name);

    reader.expect(B5Lang.BLOCK);

    PBlock.parse(reader, program, loop.body, B5Lang.END);

    reader.expect(B5Lang.END);

    block.add(loop);
  }

}
