package org.bm.b5.parsing.units.instructions;

import org.bm.b5.B5Program;
import org.bm.b5.collections.B5Block;
import org.bm.b5.instructions.B5Put;
import org.bm.b5.instructions.B5Return;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PExpr;

public class PReturn {

  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    B5Return ret = new B5Return(block);

    reader.expect(B5Lang.RETURN);

    ret.value = PExpr.parse(reader, program, ret);

    block.add(ret);
  }

}
