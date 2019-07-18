package org.bm.b5.parsing;

import org.bm.b5.design.B5Program;
import org.bm.b5.parsing.entities.PProc;
import org.bm.b5.parsing.entities.PScalar;
import org.bm.b5.parsing.entities.PType;

public class PEntity {

  public static void parse(B5Reader reader, B5Program program) {
    if (reader.test(B5Lang.PROC)) {
      PProc.parse(reader, program);
    }
    else if (reader.test(B5Lang.TYPE)) {
      PType.parse(reader, program);
    }
    else if (reader.test(B5Lang.SCALAR)) {
      PScalar.parse(reader, program);
    }
    else {
      throw reader.error("expected to read an entity instead of: " + reader.nextToken());
    }
  }

}
