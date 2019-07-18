package org.bm.b5.parsing.entities;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Scalar;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PBlock;

public class PScalar {

  public static void parse(B5Reader reader, B5Program program) {
    reader.expect(B5Lang.SCALAR);

    B5Scalar scalar = reader.nextScalar(program);

    reader.expect(B5Lang.AS);

    scalar.type = reader.nextType(program);

    reader.expect(B5Lang.INIT);

    PBlock.parse(reader, program, scalar.init, B5Lang.END);

    reader.expect(B5Lang.END);

    scalar.defined = true;
  }

}