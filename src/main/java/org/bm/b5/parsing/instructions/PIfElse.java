package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.instructions.B5IfElse;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PBlock;
import org.bm.b5.parsing.PExpr;

public class PIfElse {

  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    B5IfElse ifElse = new B5IfElse(block);

    reader.expect(B5Lang.IF);

    ifElse.condition = PExpr.parse(reader, program, ifElse);

    reader.expect(B5Lang.THEN);

    PBlock.parse(reader, program, ifElse.thenBody, B5Lang.ELSE, B5Lang.END);

    if (reader.pull(B5Lang.ELSE)) {
      PBlock.parse(reader, program, ifElse.elseBody, B5Lang.END);
    }

    reader.expect(B5Lang.END);

    block.add(ifElse);
  }

}
