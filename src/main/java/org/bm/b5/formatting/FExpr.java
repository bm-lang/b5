package org.bm.b5.formatting;

import org.bm.b5.B5Exception;
import org.bm.b5.design.expressions.*;

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
  }

  private static void writeBitAnd(FWriter writer, B5BitAnd expr) {
  }

  private static void writeBitNot(FWriter writer, B5BitNot expr) {
  }

  private static void writeBitOr(FWriter writer, B5BitOr expr) {
  }

  private static void writeBitXor(FWriter writer, B5BitXor expr) {
  }

  private static void writeBoolAnd(FWriter writer, B5BoolAnd expr) {
  }

  private static void writeBoolNot(FWriter writer, B5BoolNot expr) {
  }

  private static void writeBoolOr(FWriter writer, B5BoolOr expr) {
  }

  private static void writeCast(FWriter writer, B5Cast expr) {
  }

  private static void writeFetch(FWriter writer, B5Fetch expr) {
  }

  private static void writeGet(FWriter writer, B5Get expr) {
  }

  private static void writeIs(FWriter writer, B5Is expr) {
  }

  private static void writeLen(FWriter writer, B5Len expr) {
  }

  private static void writeLiteral(FWriter writer, B5Literal expr) {
  }

  private static void writeNull(FWriter writer, B5Null expr) {
  }

  private static void writeNumAdd(FWriter writer, B5NumAdd expr) {
  }

  private static void writeNumDiv(FWriter writer, B5NumDiv expr) {
  }

  private static void writeNumMod(FWriter writer, B5NumMod expr) {
  }

  private static void writeNumMul(FWriter writer, B5NumMul expr) {
  }

  private static void writeNumSub(FWriter writer, B5NumSub expr) {
  }

  private static void writeObject(FWriter writer, B5Object expr) {
  }

  private static void writeRef(FWriter writer, B5Ref expr) {
  }

  private static void writeRelEq(FWriter writer, B5RelEq expr) {
  }

  private static void writeRelGt(FWriter writer, B5RelGt expr) {
  }

  private static void writeRelGte(FWriter writer, B5RelGte expr) {
  }

  private static void writeRelLt(FWriter writer, B5RelLt expr) {
  }

  private static void writeRelLte(FWriter writer, B5RelLte expr) {
  }

  private static void writeRelNeq(FWriter writer, B5RelNeq expr) {
  }

}
