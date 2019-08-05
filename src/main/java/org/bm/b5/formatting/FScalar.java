package org.bm.b5.formatting;

import org.bm.b5.design.entities.B5Scalar;
import org.bm.b5.formatting.FWriter;
import org.bm.b5.parsing.B5Lang;

public class FScalar {
  public static void write(FWriter writer, B5Scalar scalar) {
    writer.write(B5Lang.SCALAR);
    writer.write(scalar.name);
    writer.write(B5Lang.AS);
    writer.writeLine(scalar.type.name);

    writer.write(B5Lang.INIT);
    FInstr.write(writer, scalar.init);
    writer.writeLine();
  }
}
