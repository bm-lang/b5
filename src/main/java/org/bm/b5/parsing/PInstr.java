package org.bm.b5.parsing;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.instructions.*;
import org.bm.b5.parsing.expressions.PRef;

public class PInstr {
  public static B5Instr parse(B5Reader reader, B5Program program, B5Scope scope) {
    if (reader.test(B5Lang.BEGIN)) {
      return parseBlock(reader, program, scope);
    }
    else if (reader.test(B5Lang.CALL)) {
      return parseCall(reader, program, scope);
    }
    else if (reader.test(B5Lang.DEBUG)) {
      return parseDebug(reader, program, scope);
    }
    else if (reader.test(B5Lang.DECLARE)) {
      return parseDeclare(reader, program, scope);
    }
    else if (reader.test(B5Lang.EXIT)) {
      return parseExit(reader, program, scope);
    }
    else if (reader.test(B5Lang.IF)) {
      return parseIfElse(reader, program, scope);
    }
    else if (reader.test(B5Lang.JUMP)) {
      return parseJump(reader, program, scope);
    }
    else if (reader.test(B5Lang.LOOP)) {
      return parseLoop(reader, program, scope);
    }
    else if (reader.test(B5Lang.MARK)) {
      return parseMark(reader, program, scope);
    }
    else if (reader.test(B5Lang.PUT)) {
      return parsePut(reader, program, scope);
    }
    else if (reader.test(B5Lang.RETURN)) {
      return parseReturn(reader, program, scope);
    }
    else if (reader.test(B5Lang.SET)) {
      return parseSet(reader, program, scope);
    }
    else {
      throw reader.error("unknown instruction: " + reader.nextToken());
    }
  }

  public static B5Block parseBlock(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.BEGIN);

    B5Block block = new B5Block(scope);

    B5Instr prev = null;

    while(!reader.pull(B5Lang.END)) {
      B5Instr curr = PInstr.parse(reader, program, block);

      if (prev != null) {
        prev.next = curr;
        curr.prev = prev;
      }

      if (block.instr == null) {
        block.instr = curr;
      }

      prev = curr;
    }

    if (block.instr == null) {
      block.instr = new B5Nop(scope);
    }

    return block;
  }

  public static B5Call parseCall(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.CALL);

    B5Proc proc = reader.nextProc(program);

    B5Call call = new B5Call(scope, proc);

    if (reader.pull(B5Lang.ARGS)) {
      do {
        B5Expr arg = PExpr.parse(reader, program, call);

        call.args.add(arg);
      }
      while (reader.pull(','));
    }

    return call;
  }

  public static B5Debug parseDebug(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.DEBUG);

    String output = reader.nextToken();

    return new B5Debug(scope, output);
  }

  public static B5Declare parseDeclare(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.DECLARE);

    String name = reader.nextToken();

    reader.expect(B5Lang.AS);

    B5Type type = reader.nextType(program);

    B5Declare instr = new B5Declare(scope, name, type);

    reader.expect(B5Lang.WITH);

    instr.value = PExpr.parse(reader, program, instr);

    return instr;
  }

  public static B5Exit parseExit(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.EXIT);

    return new B5Exit(scope);
  }

  public static B5IfElse parseIfElse(B5Reader reader, B5Program program, B5Scope scope) {
    B5IfElse ifElse = new B5IfElse(scope);

    reader.expect(B5Lang.IF);

    ifElse.condition = PExpr.parse(reader, program, ifElse);

    reader.expect(B5Lang.THEN);

    ifElse.thenInstr = PInstr.parse(reader, program, ifElse);

    if (reader.pull(B5Lang.ELSE)) {
      ifElse.elseInstr = PInstr.parse(reader, program, ifElse);
    }

    return ifElse;
  }

  public static B5Jump parseJump(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.JUMP);

    String markName = reader.nextToken();

    return new B5Jump(scope, markName);
  }

  public static B5Loop parseLoop(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.LOOP);

    B5Loop loop = new B5Loop(scope);

    loop.instr = PInstr.parse(reader, program, loop);

    return loop;
  }

  public static B5Mark parseMark(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.MARK);

    String markName = reader.nextToken();

    return new B5Mark(scope, markName);
  }

  public static B5Put parsePut(B5Reader reader, B5Program program, B5Scope scope) {
    B5Put put = new B5Put(scope);

    reader.expect(B5Lang.PUT);

    put.array = PExpr.parse(reader, program, put);

    reader.expect(B5Lang.INDEX);

    put.index = PExpr.parse(reader, program, put);

    reader.expect(B5Lang.VALUE);

    put.value = PExpr.parse(reader, program, put);

    return put;
  }

  public static B5Return parseReturn(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.RETURN);

    B5Return ret = new B5Return(scope);

    ret.value = PExpr.parse(reader, program, ret);

    return ret;
  }

  public static B5Set parseSet(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.SET);

    B5Set set = new B5Set(scope);

    set.ref = PRef.parse(reader, program, set);

    reader.expect(B5Lang.VALUE);

    set.value = PExpr.parse(reader, program, set);

    return set;
  }
}
