package org.bm.b5.parsing.units;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Program;
import org.bm.b5.expressions.B5BinaryOperator;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.expressions.B5UnaryOperator;
import org.bm.b5.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.expressions.*;
import org.bm.b5.parsing.units.expressions.operators.PBinaryOperation;
import org.bm.b5.parsing.units.expressions.operators.PUnaryOperation;

public class PExpr {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Instr instr) {
    if (reader.test(B5Lang.REF)) {
      return PRef.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.NEW)) {
      return PNew.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.ARRAY)) {
      return PArray.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.LITERAL)) {
      return PLiteral.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.IS)) {
      return PIs.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.FETCH)) {
      return PFetch.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.LEN)) {
      return PLen.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.GET)) {
      return PGet.parse(reader, program, instr);
    }

    for (B5UnaryOperator op : B5UnaryOperator.values()) {
      if (reader.test(op)) {
        return PUnaryOperation.parse(reader, program, instr, op);
      }
    }

    for (B5BinaryOperator op : B5BinaryOperator.values()) {
      if (reader.test(op)) {
        return PBinaryOperation.parse(reader, program, instr, op);
      }
    }

    throw reader.error("unknown expression: " + reader.nextToken());
  }

}
