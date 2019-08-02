package org.bm.b5.runtime.values;

import org.bm.b5.runtime.RException;
import org.bm.b5.runtime.RValue;

abstract public class RPlain implements RValue {

  @Override
  public final RValue get(String member) {
    throw new RException("no members");
  }

  @Override
  public final void set(String member, RValue value) {
    throw new RException("no members");
  }

}
