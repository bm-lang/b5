package org.bm.b5.parsing;

import org.bm.b5.design.B5Program;

public class PProgram {

  public static void parse(B5Reader reader, B5Program program) {
    while (reader.alive()) {
      PEntity.parse(reader, program);
    }
  }

}
