package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Set;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;
import org.bm.b5.parsing.expressions.PRef;

public class PSet {

  public static B5Set parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.SET);

    B5Set set = new B5Set(scope);

    set.ref = PRef.parse(reader, program, set);

    reader.expect(B5Lang.VALUE);

    set.value = PExpr.parse(reader, program, set);

    return set;
  }

}
