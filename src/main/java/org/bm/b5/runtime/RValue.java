package org.bm.b5.runtime;

import org.bm.b5.design.entities.B5Type;

public interface RValue {

  RValue get(String member);

  void set(String member, RValue value);

  B5Type getType();

}
