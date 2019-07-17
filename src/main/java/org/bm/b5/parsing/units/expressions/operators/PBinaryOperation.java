package org.bm.b5.parsing.units.expressions.operators;

import org.bm.b5.B5Program;
import org.bm.b5.expressions.*;
import org.bm.b5.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PExpr;

public class PBinaryOperation {

  public static B5BinaryOperation parse(B5Reader reader, B5Program program, B5Instr instr, B5BinaryOperator op) {
    reader.expect(op);

    B5Expr left = PExpr.parse(reader, program, instr);

    reader.expect(B5Lang.WITH);

    B5Expr right = PExpr.parse(reader, program, instr);

    return new B5BinaryOperation(instr, op, left, right);
  }

}
