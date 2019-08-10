package org.bm.b5.parsing;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.*;

import java.util.ArrayList;

public class PExpr {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Scope scope) {
    if (reader.test(B5Lang.ARRAY)) {
      return parseArray(reader, program, scope);
    }
    else if (reader.test(B5Lang.BWA)) {
      return parseBitAnd(reader, program, scope);
    }
    else if (reader.test(B5Lang.BWN)) {
      return parseBitNot(reader, program, scope);
    }
    else if (reader.test(B5Lang.BWO)) {
      return parseBitOr(reader, program, scope);
    }
    else if (reader.test(B5Lang.BWX)) {
      return parseBitXor(reader, program, scope);
    }
    else if (reader.test(B5Lang.AND)) {
      return parseBoolAnd(reader, program, scope);
    }
    else if (reader.test(B5Lang.NOT)) {
      return parseBoolNot(reader, program, scope);
    }
    else if (reader.test(B5Lang.OR)) {
      return parseBoolOr(reader, program, scope);
    }
    else if (reader.test(B5Lang.CAST)) {
      return parseCast(reader, program, scope);
    }
    else if (reader.test(B5Lang.FETCH)) {
      return parseFetch(reader, program, scope);
    }
    else if (reader.test(B5Lang.GET)) {
      return parseGet(reader, program, scope);
    }
    else if (reader.test(B5Lang.IS)) {
      return parseIs(reader, program, scope);
    }
    else if (reader.test(B5Lang.LEN)) {
      return parseLen(reader, program, scope);
    }
    else if (reader.test(B5Lang.LITERAL)) {
      return parseLiteral(reader, program, scope);
    }
    else if (reader.test(B5Lang.NULL)) {
      return parseNull(reader, program, scope);
    }
    else if (reader.test(B5Lang.ADD)) {
      return parseNumAdd(reader, program, scope);
    }
    else if (reader.test(B5Lang.DIV)) {
      return parseNumDiv(reader, program, scope);
    }
    else if (reader.test(B5Lang.MOD)) {
      return parseNumMod(reader, program, scope);
    }
    else if (reader.test(B5Lang.MUL)) {
      return parseNumMul(reader, program, scope);
    }
    else if (reader.test(B5Lang.SUB)) {
      return parseNumSub(reader, program, scope);
    }
    else if (reader.test(B5Lang.OBJECT)) {
      return parseObject(reader, program, scope);
    }
    else if (reader.test(B5Lang.REF)) {
      return parseRef(reader, program, scope);
    }
    else if (reader.test(B5Lang.EQ)) {
      return parseRelEq(reader, program, scope);
    }
    else if (reader.test(B5Lang.GT)) {
      return parseRelGt(reader, program, scope);
    }
    else if (reader.test(B5Lang.GTE)) {
      return parseRelGte(reader, program, scope);
    }
    else if (reader.test(B5Lang.LT)) {
      return parseRelLt(reader, program, scope);
    }
    else if (reader.test(B5Lang.LTE)) {
      return parseRelLte(reader, program, scope);
    }
    else if (reader.test(B5Lang.NEQ)) {
      return parseRelNeq(reader, program, scope);
    }
    else {
      throw reader.error("unknown expression: " + reader.nextToken());
    }
  }

  public static B5Array parseArray(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.ARRAY);

    B5Expr size = PExpr.parse(reader, program, scope);

    return new B5Array(scope, size);
  }

  public static B5Expr parseBitAnd(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.BWA);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5BitAnd(scope, left, right);
  }

  public static B5BitNot parseBitNot(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.BWN);

    B5Expr value = PExpr.parse(reader, program, scope);

    return new B5BitNot(scope, value);
  }

  public static B5Expr parseBitOr(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.BWO);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5BitOr(scope, left, right);
  }

  public static B5Expr parseBitXor(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.BWX);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5BitXor(scope, left, right);
  }

  public static B5Expr parseBoolAnd(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.AND);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5BoolAnd(scope, left, right);
  }

  public static B5BoolNot parseBoolNot(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.NOT);

    B5Expr value = PExpr.parse(reader, program, scope);

    return new B5BoolNot(scope, value);
  }

  public static B5Expr parseBoolOr(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.OR);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5BoolOr(scope, left, right);
  }

  public static B5Expr parseCast(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.CAST);

    B5Expr value = PExpr.parse(reader, program, scope);

    reader.expect(B5Lang.AS);

    B5Type type = reader.nextType(program);

    return new B5Cast(scope, value, type);
  }

  public static B5Expr parseFetch(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.FETCH);

    B5Proc proc = reader.nextProc(program);
    B5Fetch fetch = new B5Fetch(scope, proc);

    if (reader.pull(B5Lang.ARGS)) {
      do {
        B5Expr arg = PExpr.parse(reader, program, scope);

        fetch.args.add(arg);
      }
      while (reader.pull(','));
    }

    return fetch;
  }

  public static B5Expr parseGet(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.GET);

    B5Expr array = PExpr.parse(reader, program, scope);

    reader.expect(B5Lang.INDEX);

    B5Expr index = PExpr.parse(reader, program, scope);

    return new B5Get(scope, array, index);
  }

  public static B5Expr parseIs(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.IS);

    B5Expr value = PExpr.parse(reader, program, scope);

    reader.expect(B5Lang.OF);

    B5Type type = reader.nextType(program);

    return new B5Is(scope, value, type);
  }

  public static B5Expr parseLen(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.LEN);

    B5Expr array = PExpr.parse(reader, program, scope);

    return new B5Len(scope, array);
  }

  public static B5Expr parseLiteral(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.LITERAL);

    String value = reader.nextToken();

    reader.expect(B5Lang.AS);

    B5Type type = reader.nextType(program);

    return new B5Literal(scope, value, type);
  }

  public static B5Null parseNull(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.NULL);

    return new B5Null(scope);
  }

  public static B5Expr parseNumAdd(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.ADD);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5NumAdd(scope, left, right);
  }

  public static B5Expr parseNumDiv(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.DIV);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5NumDiv(scope, left, right);
  }

  public static B5Expr parseNumMod(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.MOD);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5NumMod(scope, left, right);
  }

  public static B5Expr parseNumMul(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.MUL);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5NumMul(scope, left, right);
  }

  public static B5Expr parseNumSub(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.SUB);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5NumSub(scope, left, right);
  }

  public static B5Expr parseObject(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.OBJECT);

    B5Type type = reader.nextType(program);

    return new B5Object(scope, type);
  }

  public static B5Ref parseRef(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.REF);

    ArrayList<String> items = new ArrayList<>();

    do {
      String part = reader.nextToken();

      items.add(part);
    }
    while(reader.pull('.'));

    return new B5Ref(scope, items);
  }

  public static B5Expr parseRelEq(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.EQ);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5RelEq(scope, left, right);
  }

  public static B5Expr parseRelGt(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.GT);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5RelGt(scope, left, right);
  }

  public static B5Expr parseRelGte(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.GTE);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5RelGte(scope, left, right);
  }

  public static B5Expr parseRelLt(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.LT);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5RelLt(scope, left, right);
  }

  public static B5Expr parseRelLte(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.LTE);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5RelLte(scope, left, right);
  }

  public static B5Expr parseRelNeq(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.NEQ);

    B5Expr left = PExpr.parse(reader, program, scope);

    reader.expect(',');

    B5Expr right = PExpr.parse(reader, program, scope);

    return new B5RelNeq(scope, left, right);
  }

}
