package org.bm.b5;

import org.bm.b5.entities.B5Block;

public interface B5Scope {

  void link();

  B5Linkable findLinkable(String name);

  B5Block getContextBlock();
}
