package org.bm.b5;

import org.bm.b5.entities.B5Type;

public interface B5Linkable {

  String getName();

  B5Linkable pick(String member);

  B5Type getType();
}
