package org.bm.b5.runtime;

abstract public class RValue {

  abstract public RValue get(String member);

  abstract public void set(String member, RValue value);
}
