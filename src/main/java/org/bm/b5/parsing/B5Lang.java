package org.bm.b5.parsing;

public enum B5Lang {

  SCALAR,
  INIT,

  PROC,
  PARAMS,
  RETURNS,
  BODY,
  MAIN,

  TYPE,
  EXTENDS,
  FIELDS,

  AS,
  END,
  BEGIN,

  // INSTRUCTIONS

  DECLARE,
  WITH,
  SET,
  IF,
  THEN,
  ELSE,
  LOOP,
  JUMP,
  MARK,
  CALL,
  RETURN,
  EXIT,
  PUT,

  // EXPRESSIONS

  REF,
  OBJECT,
  ARRAY,
  IS,
  LITERAL,
  FETCH,
  LEN,
  GET,
  NULL,
  NOT,
  BWN,

  ARGS,
  INDEX,
  VALUE,
  OF,
  BWA,
  BWO,
  BWX,
  AND,
  OR,
  ADD,
  DIV,
  MOD,
  MUL,
  SUB,
  EQ,
  GT,
  GTE,
  LT,
  LTE,
  NEQ,
  CAST,
  DEBUG;

}
