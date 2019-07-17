#include <stdlib.h>
#include <stdio.h>

typedef unsigned int OBJECT_ID;
typedef unsigned int REF_COUNT;

#define OBJECT_FIELDS OBJECT_ID object_id; \
        REF_COUNT ref_count

#define NEW(T) (T*)malloc(sizeof(T))

typedef struct { OBJECT_FIELDS; } OBJECT;

OBJECT_ID LAST_OBJECT_ID = 0;
OBJECT_ID NEXT_OBJECT_ID() {
  return ++LAST_OBJECT_ID;
}

void OBJECT_INIT(OBJECT* obj) {
  obj->object_id = NEXT_OBJECT_ID();
  obj->ref_count = 0;
}

void ENTER_SCOPE(OBJECT* obj) {
  if (obj) {
    obj->ref_count++;
  }
}

void EXIT_SCOPE(OBJECT* obj) {
  if (obj) {
    obj->ref_count--;
  }
}