package org.bm.b5.parsing;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PType {

  public static void parse(B5Reader reader, B5Program program) {
    reader.expect(B5Lang.TYPE);

    B5Type type = reader.nextType(program);

    if (type.defined) {
      throw reader.error("the type '" + type + "' is already defined");
    }

    if (reader.pull(B5Lang.EXTENDS)) {
      type.superType = reader.nextType(program);
    }

    if (reader.pull(B5Lang.FIELDS)) {
      do {
        String fieldName = reader.nextToken();

        reader.expect(B5Lang.AS);

        B5Type fieldType = reader.nextType(program);

        type.fields.add(fieldName, fieldType);
      }
      while (reader.pull(','));
    }

    type.defined = true;
  }

}
