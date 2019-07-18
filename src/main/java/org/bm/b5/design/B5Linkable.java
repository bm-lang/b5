package org.bm.b5.design;

import org.bm.b5.design.entities.B5Type;

public interface B5Linkable {

  String getName();

  B5Linkable pick(String member);

  B5Type getType();
}
