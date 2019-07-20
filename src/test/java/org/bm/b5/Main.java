package org.bm.b5;

import org.bm.b5.design.B5Program;
import org.bm.b5.parsing.B5Parser;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.runtime.RMachine;
import org.junit.Test;

public class Main {

  @Test
  public void main() {
    B5Reader reader = B5Reader.fromResource("/test.b5", Main.class);
    B5Program program = new B5Program();

    B5Parser.parse(reader, program);

    program.checkDefinition();
    program.linkReferences();
    program.checkTypes();

    new RMachine().run(program);

//    try(CWriter writer = new CWriter(System.out)) {
//      CCompiler compiler = new CCompiler(writer);
//
//      compiler.compile(program);
//    }
  }

}
