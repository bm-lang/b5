package org.bm.b5;

import org.bm.b5.design.B5Program;
import org.bm.b5.formatting.FProgram;
import org.bm.b5.formatting.FWriter;
import org.bm.b5.parsing.B5Parser;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.runtime.RMachine;
import org.junit.Test;

public class Main {

  @Test
  public void main() {
    String[] files = { "/test.b5", "/lambda.b5" };

    for (String fileName : files) {
      B5Reader reader = B5Reader.fromResource(fileName, Main.class);
      B5Program program = new B5Program();

      B5Parser.parse(reader, program);

      program.link();
      program.compile();

      new RMachine(program).run();

      try (FWriter writer = new FWriter(System.out)) {
        FProgram.write(writer, program);
      }
    }
  }

}
