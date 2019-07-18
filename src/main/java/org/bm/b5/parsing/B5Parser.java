package org.bm.b5.parsing;

import org.bm.b5.design.B5Program;

public class B5Parser {

  public static void parse(B5Reader reader, B5Program program) {
    B5Parser parser = new B5Parser(reader, program);

    parser.readProgram();
  }

  private final B5Reader reader;
  private final B5Program program;

  private B5Parser(B5Reader reader, B5Program program) {
    this.reader = reader;
    this.program = program;
  }

  // READS

  public void readProgram() {
    while (reader.alive()) {
      PEntity.parse(reader, program);
    }
  }

}
