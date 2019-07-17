#include "includes/b5.h"

typedef struct {
  OBJECT_FIELDS;
  int x;
  int y;
} Point2D;

typedef struct {
  OBJECT_FIELDS;
  int x;
  int y;
  int z;
} Point3D;

void printObject(OBJECT* o) {
  printf("OBJECT(id: %i, rc: %i)\n", o->object_id, o->ref_count);
}

void print2D(Point2D* p) {
  printf("Point2D(%i, %i)\n", p->x, p->y);
}

void print3D(Point3D* p) {
  printf("Point3D(%i, %i, %i)\n", p->x, p->y, p->z);
}

int main() {
  Point2D* p2d = NEW(Point2D);
  Point3D* p3d = NEW(Point3D);

  OBJECT_INIT((OBJECT*)p2d);
  OBJECT_INIT((OBJECT*)p3d);

  p2d->x = 1;
  p2d->y = 2;

  p3d->x = 3;
  p3d->y = 4;
  p3d->z = 5;

  printObject((OBJECT*)p2d);
  printObject((OBJECT*)p3d);
  print2D(p2d);
  print2D((Point2D*)p3d);
  print3D(p3d);

  return 0;
}

// gcc test.c -o test && ./test && rm test;