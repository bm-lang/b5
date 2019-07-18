package org.bm.b5.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Linkable;
import org.bm.b5.instructions.B5Instr;

import java.util.List;

public class B5Ref extends B5Expr {

  public final List<String> path;

  public B5Linkable linkedRef;

  public B5Ref(B5Instr instr, List<String> path) {
    super(instr);
    this.path = path;
  }

  @Override
  public void checkDefinition() {
    if (path.isEmpty()) {
      throw new B5Exception("reference path cannot be empty");
    }
  }

  @Override
  public void resolve() {
    String firstName = path.get(0);

    B5Linkable linkable = instr.findLinkable(firstName);

    for (int i = 1; i < path.size(); i++) {
      linkable = linkable.pick(path.get(i));
    }

    linkedRef = linkable;
  }

}
