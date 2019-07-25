package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Mark;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PMark {

  public static B5Mark parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.MARK);

    String markName = reader.nextToken();

    return new B5Mark(scope, markName);
  }

}
