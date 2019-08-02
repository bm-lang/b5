package org.bm.b5.parsing.expressions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.expressions.B5Object;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PObject {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.OBJECT);

    B5Type type = reader.nextType(program);

    return new B5Object(scope, type);
  }

}
