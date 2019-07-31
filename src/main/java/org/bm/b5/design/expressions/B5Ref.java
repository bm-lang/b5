package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

import java.util.List;

public class B5Ref extends B5Expr {

  public final List<String> path;

  public B5Linkable linkedRef;

  public B5Ref(B5Scope scope, List<String> path) {
    super(scope);
    this.path = path;
  }

  @Override
  public void link() {
    String firstName = path.get(0);

    B5Linkable linkable = scope.findLinkable(firstName);

    for (int i = 1; i < path.size(); i++) {
      linkable = linkable.pick(path.get(i));
    }

    linkedRef = linkable;
  }

  @Override
  public void compile() {
    if (path.isEmpty()) {
      throw new B5Exception("reference path cannot be empty");
    }
    if (linkedRef == null) {
      throw new B5Exception("reference is not linked: " + String.join(", ", path));
    }

    setResultingType(linkedRef.getType());
  }
}
