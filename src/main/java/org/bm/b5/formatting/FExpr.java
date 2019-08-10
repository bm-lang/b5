package org.bm.b5.formatting;

import org.bm.b5.B5Exception;
import org.bm.b5.design.expressions.*;
import org.bm.b5.parsing.B5Lang;

import java.util.Arrays;

public class FExpr {
  public static void write(FWriter writer, B5Expr expr) {
    if (expr instanceof B5Array) {
      writeArray(writer, (B5Array)expr);
    }
    else if (expr instanceof B5BitAnd) {
      writeBitAnd(writer, (B5BitAnd)expr);
    }
    else if (expr instanceof B5BitNot) {
      writeBitNot(writer, (B5BitNot)expr);
    }
    else if (expr instanceof B5BitOr) {
      writeBitOr(writer, (B5BitOr)expr);
    }
    else if (expr instanceof B5BitXor) {
      writeBitXor(writer, (B5BitXor)expr);
    }
    else if (expr instanceof B5BoolAnd) {
      writeBoolAnd(writer, (B5BoolAnd)expr);
    }
    else if (expr instanceof B5BoolNot) {
      writeBoolNot(writer, (B5BoolNot)expr);
    }
    else if (expr instanceof B5BoolOr) {
      writeBoolOr(writer, (B5BoolOr)expr);
    }
    else if (expr instanceof B5Cast) {
      writeCast(writer, (B5Cast)expr);
    }
    else if (expr instanceof B5Fetch) {
      writeFetch(writer, (B5Fetch)expr);
    }
    else if (expr instanceof B5Get) {
      writeGet(writer, (B5Get)expr);
    }
    else if (expr instanceof B5Is) {
      writeIs(writer, (B5Is)expr);
    }
    else if (expr instanceof B5Len) {
      writeLen(writer, (B5Len)expr);
    }
    else if (expr instanceof B5Literal) {
      writeLiteral(writer, (B5Literal)expr);
    }
    else if (expr instanceof B5Null) {
      writeNull(writer, (B5Null)expr);
    }
    else if (expr instanceof B5NumAdd) {
      writeNumAdd(writer, (B5NumAdd)expr);
    }
    else if (expr instanceof B5NumDiv) {
      writeNumDiv(writer, (B5NumDiv)expr);
    }
    else if (expr instanceof B5NumMod) {
      writeNumMod(writer, (B5NumMod)expr);
    }
    else if (expr instanceof B5NumMul) {
      writeNumMul(writer, (B5NumMul)expr);
    }
    else if (expr instanceof B5NumSub) {
      writeNumSub(writer, (B5NumSub)expr);
    }
    else if (expr instanceof B5Object) {
      writeObject(writer, (B5Object)expr);
    }
    else if (expr instanceof B5Ref) {
      writeRef(writer, (B5Ref)expr);
    }
    else if (expr instanceof B5RelEq) {
      writeRelEq(writer, (B5RelEq)expr);
    }
    else if (expr instanceof B5RelGt) {
      writeRelGt(writer, (B5RelGt)expr);
    }
    else if (expr instanceof B5RelGte) {
      writeRelGte(writer, (B5RelGte)expr);
    }
    else if (expr instanceof B5RelLt) {
      writeRelLt(writer, (B5RelLt)expr);
    }
    else if (expr instanceof B5RelLte) {
      writeRelLte(writer, (B5RelLte)expr);
    }
    else if (expr instanceof B5RelNeq) {
      writeRelNeq(writer, (B5RelNeq)expr);
    }
    else {
      throw new B5Exception("Unknown expression");
    }
  }

  private static void writeArray(FWriter writer, B5Array expr) {
    writer.write(B5Lang.ARRAY);
    FExpr.write(writer, expr.size);
  }

  private static void writeBit2(FWriter writer, Enum<?> token, B5Bit2 expr) {
    writer.write(token);
    writer.writeList(
        Arrays.asList(expr.left, expr.right),
        item -> FExpr.write(writer, item)
    );
  }

  private static void writeBitAnd(FWriter writer, B5BitAnd expr) {
    writeBit2(writer, B5Lang.BWA, expr);
  }

  private static void writeBitNot(FWriter writer, B5BitNot expr) {
    writer.write(B5Lang.BWN);
    FExpr.write(writer, expr.value);
  }

  private static void writeBitOr(FWriter writer, B5BitOr expr) {
    writeBit2(writer, B5Lang.BWO, expr);
  }

  private static void writeBitXor(FWriter writer, B5BitXor expr) {
    writeBit2(writer, B5Lang.BWX, expr);
  }

  private static void writeBool2(FWriter writer, Enum<?> token, B5Bool2 expr) {
    writer.write(token);
    writer.writeList(
        Arrays.asList(expr.left, expr.right),
        item -> FExpr.write(writer, item)
    );
  }

  private static void writeBoolAnd(FWriter writer, B5BoolAnd expr) {
    writeBool2(writer, B5Lang.AND, expr);
  }

  private static void writeBoolNot(FWriter writer, B5BoolNot expr) {
    writer.write(B5Lang.NOT);
    FExpr.write(writer, expr.value);
  }

  private static void writeBoolOr(FWriter writer, B5BoolOr expr) {
    writeBool2(writer, B5Lang.OR, expr);
  }

  private static void writeCast(FWriter writer, B5Cast expr) {
    writer.write(B5Lang.CAST);
    FExpr.write(writer, expr.value);
    writer.write(B5Lang.AS);
    writer.write(expr.type.name);
  }

  private static void writeFetch(FWriter writer, B5Fetch expr) {
    writer.write(B5Lang.FETCH);
    writer.write(expr.proc.name);
    if (expr.args.size() > 0) {
      writer.write(B5Lang.ARGS);
      writer.writeList(expr.args, arg -> {
        FExpr.write(writer, arg);
      });
    }
  }

  private static void writeGet(FWriter writer, B5Get expr) {
    writer.write(B5Lang.GET);
    FExpr.write(writer, expr.array);
    writer.write(B5Lang.INDEX);
    FExpr.write(writer, expr.index);
  }

  private static void writeIs(FWriter writer, B5Is expr) {
    writer.write(B5Lang.IS);
    FExpr.write(writer, expr.value);
    writer.write(B5Lang.OF);
    writer.write(expr.type.name);
  }

  private static void writeLen(FWriter writer, B5Len expr) {
    writer.write(B5Lang.LEN);
    FExpr.write(writer, expr.array);
  }

  private static void writeLiteral(FWriter writer, B5Literal expr) {
    writer.write(B5Lang.LITERAL);
    writer.write(expr.value);
    writer.write(B5Lang.AS);
    writer.write(expr.type.name);
  }

  private static void writeNull(FWriter writer, B5Null expr) {
    writer.write(B5Lang.NULL);
  }

  private static void writeNum2(FWriter writer, Enum<?> token, B5Num0 expr) {
    writer.write(token);
    writer.writeList(
        Arrays.asList(expr.left, expr.right),
        item -> FExpr.write(writer, item)
    );
  }

  private static void writeNumAdd(FWriter writer, B5NumAdd expr) {
    writeNum2(writer, B5Lang.ADD, expr);
  }

  private static void writeNumDiv(FWriter writer, B5NumDiv expr) {
    writeNum2(writer, B5Lang.DIV, expr);
  }

  private static void writeNumMod(FWriter writer, B5NumMod expr) {
    writeNum2(writer, B5Lang.MOD, expr);
  }

  private static void writeNumMul(FWriter writer, B5NumMul expr) {
    writeNum2(writer, B5Lang.MUL, expr);
  }

  private static void writeNumSub(FWriter writer, B5NumSub expr) {
    writeNum2(writer, B5Lang.SUB, expr);
  }

  private static void writeObject(FWriter writer, B5Object expr) {
    writer.write(B5Lang.OBJECT);
    writer.write(expr.type.name);
  }

  public static void writeRef(FWriter writer, B5Ref expr) {
    writer.write(B5Lang.REF);
    for (int i = 0; i < expr.path.size(); i++) {
      if (i > 0) {
        writer.write(".");
      }

      writer.write(expr.path.get(i));
    }
  }

  private static void writeRel(FWriter writer, Enum<?> token, B5Rel0 expr) {
    writer.write(token);
    writer.writeList(
        Arrays.asList(expr.left, expr.right),
        item -> FExpr.write(writer, item)
    );
  }

  private static void writeRelEq(FWriter writer, B5RelEq expr) {
    writeRel(writer, B5Lang.EQ, expr);
  }

  private static void writeRelGt(FWriter writer, B5RelGt expr) {
    writeRel(writer, B5Lang.GT, expr);
  }

  private static void writeRelGte(FWriter writer, B5RelGte expr) {
    writeRel(writer, B5Lang.GTE, expr);
  }

  private static void writeRelLt(FWriter writer, B5RelLt expr) {
    writeRel(writer, B5Lang.LT, expr);
  }

  private static void writeRelLte(FWriter writer, B5RelLte expr) {
    writeRel(writer, B5Lang.LTE, expr);
  }

  private static void writeRelNeq(FWriter writer, B5RelNeq expr) {
    writeRel(writer, B5Lang.NEQ, expr);
  }

}
