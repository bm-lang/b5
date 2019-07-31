package org.bm.b5.runtime;

import org.bm.b5.design.instructions.B5Instr;

import java.util.Stack;

public class RStack {

  public static class Entry {
    public final RScope scope;
    public final B5Instr instr;

    public Entry(RScope scope, B5Instr instr) {
      this.scope = scope;
      this.instr = instr;
    }
  }

  private final Stack<Entry> stack;

  public RStack() {
    stack = new Stack<>();
  }

  public void clear() {
    stack.clear();
  }

  public Entry pop() {
    return stack.pop();
  }

  public boolean alive() {
    return stack.size() > 0;
  }

  public boolean push(RScope scope, B5Instr instr) {
    if (instr != null) {
      stack.push(new Entry(scope, instr));
      return true;
    }

    return false;
  }
}
