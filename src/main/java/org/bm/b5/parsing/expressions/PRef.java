package org.bm.b5.parsing.expressions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.expressions.B5Ref;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

import java.util.ArrayList;

public class PRef {

  public static B5Ref parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.REF);

    ArrayList<String> items = new ArrayList<>();

    do {
      String part = reader.nextToken();

      items.add(part);
    }
    while(reader.pull('.'));

    return new B5Ref(scope, items);
  }

}
