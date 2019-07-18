package org.bm.b5;

import org.bm.b5.parsing.B5Parser;
import org.bm.b5.parsing.B5Reader;
import org.junit.Test;

public class Main {

  @Test
  public void main() {
    B5Reader reader = B5Reader.fromResource("/test.b5", Main.class);
    B5Program program = new B5Program();

    B5.createNativeTypes(program);

    B5Parser.parse(reader, program);

    program.checkDefinition();
    program.linkReferences();

//    try(CWriter writer = new CWriter(System.out)) {
//      CCompiler compiler = new CCompiler(writer);
//
//      compiler.compile(program);
//    }
  }

}
