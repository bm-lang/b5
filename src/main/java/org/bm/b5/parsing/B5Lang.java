package org.bm.b5.parsing;

public enum B5Lang {

  SCALAR,
  INIT,

  PROC,
  PARAM,
  RETURNS,
  BODY,
  MAIN,

  TYPE,
  EXTENDS,
  FIELD,

  AS,
  END,

  // INSTRUCTIONS

  DECLARE,
  SET,
  IF,
  THEN,
  ELSE,
  LOOP,
  BLOCK,
  BREAK,
  JUMP,
  MARK,
  CALL,
  RETURN,
  EXIT,
  PUT,

  // EXPRESSIONS

  REF,
  NEW,
  ARRAY,
  IS,
  LITERAL,
  FETCH,
  LEN,
  GET,

  WITH,
  ARG,
  PICK,
  INDEX,
  VALUE,
  OF,
  ;

}
