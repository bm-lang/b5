package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Return;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;

public class PReturn {

  public static B5Return parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.RETURN);

    B5Return ret = new B5Return(scope);

    ret.value = PExpr.parse(reader, program, ret);

    return ret;
  }

}
