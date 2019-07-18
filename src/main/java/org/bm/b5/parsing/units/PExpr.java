package org.bm.b5.parsing.units;

import org.bm.b5.B5Program;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.expressions.*;

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
    else if (reader.test(B5Lang.NULL)) {
      return PNull.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.BWA)) {
      return PBitAnd.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.BWN)) {
      return PBitNot.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.BWO)) {
      return PBitOr.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.BWX)) {
      return PBitXor.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.AND)) {
      return PBoolAnd.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.NOT)) {
      return PBoolNot.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.OR)) {
      return PBoolOr.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.ADD)) {
      return PNumAdd.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.DIV)) {
      return PNumDiv.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.MOD)) {
      return PNumMod.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.MUL)) {
      return PNumMul.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.SUB)) {
      return PNumSub.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.EQ)) {
      return PRelEq.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.GT)) {
      return PRelGt.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.GTE)) {
      return PRelGte.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.LT)) {
      return PRelLt.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.LTE)) {
      return PRelLte.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.NEQ)) {
      return PRelNeq.parse(reader, program, instr);
    }
    else if (reader.test(B5Lang.CAST)) {
      return PCast.parse(reader, program, instr);
    }

    throw reader.error("unknown expression: " + reader.nextToken());
  }

}
