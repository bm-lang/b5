package org.bm.b5.parsing.units;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Program;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.entities.PProc;
import org.bm.b5.parsing.units.entities.PScalar;
import org.bm.b5.parsing.units.entities.PType;

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
