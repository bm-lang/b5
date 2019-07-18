package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.instructions.B5Return;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;

public class PReturn {

  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    B5Return ret = new B5Return(block);

    reader.expect(B5Lang.RETURN);

    ret.value = PExpr.parse(reader, program, ret);

    block.add(ret);
  }

}
