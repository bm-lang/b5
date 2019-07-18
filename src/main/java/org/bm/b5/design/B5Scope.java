package org.bm.b5.design;

import org.bm.b5.design.entities.B5Block;

public interface B5Scope {

  void linkReferences();

  B5Linkable findLinkable(String name);

  B5Block getContextBlock();

  B5Program getProgram();
}
