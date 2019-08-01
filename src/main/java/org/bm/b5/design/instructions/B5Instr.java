package org.bm.b5.design.instructions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Element;
import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

abstract public class B5Instr extends B5Element implements B5Scope {

  public abstract void linkCurrent();
  public abstract void compileCurrent();

  @Override
  public void link() {
    linkCurrent();

    if (next != null) {
      next.link();
    }
  }

  @Override
  public void compile() {
    compileCurrent();

    if (next != null) {
      next.compile();
    }
  }

  public abstract List<B5Instr> getChildren();

  public final B5Scope parent;

  public B5Instr prev;
  public B5Instr next;

  public B5Instr(B5Scope parent) {
    this.parent = parent;
  }

  public B5Instr getRoot() {
    B5Instr curr = this;
    B5Instr last = curr;

    while (curr != null) {
      if (curr.prev != null) {
        curr = curr.prev;
      }
      else if (curr.parent instanceof B5Instr) {
        curr = (B5Instr)curr.parent;
      }
      else {
        last = curr;
        curr = null;
      }
    }

    return last;
  }

  public Stream<B5Instr> walkUp() {
    AtomicReference<B5Instr> currRef = new AtomicReference<>(this);

    Iterator<B5Instr> iterator = new Iterator<B5Instr>() {
      @Override
      public boolean hasNext() {
        return currRef.get() != null;
      }

      @Override
      public B5Instr next() {
        B5Instr next = currRef.get();

        if (next == null) {
          throw new IllegalStateException();
        }

        if (next.prev != null) {
          currRef.set(next.prev);
        }
        else if (next.parent instanceof B5Instr) {
          currRef.set((B5Instr)next.parent);
        }
        else {
          currRef.set(null);
        }

        return next;
      }
    };

    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(iterator, Spliterator.SIZED), false
    );
  }

  public Stream<B5Instr> walkDown() {
    Stack<B5Instr> stack = new Stack<>();

    stack.push(this);

    Iterator<B5Instr> iterator = new Iterator<B5Instr>() {
      @Override
      public boolean hasNext() {
        return stack.size() > 0;
      }

      @Override
      public B5Instr next() {
        if (stack.isEmpty()) {
          throw new IllegalStateException();
        }

        B5Instr next = stack.pop();

        List<B5Instr> children = next.getChildren();

        if (next.next != null) {
          stack.push(next.next);
        }

        if (children != null && children.size() > 0) {
          for (int i = children.size() - 1; i >= 0; i--) {
            stack.push(children.get(i));
          }
        }

        return next;
      }

    };

    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(iterator, Spliterator.SIZED), false
    );
  }

  public B5Linkable findLinkable(String name) {
    return walkUp()
        .filter(instr -> instr instanceof B5Linkable)
        .map(instr -> (B5Linkable)instr)
        .filter(linkable -> Objects.equals(linkable.getName(), name))
        .reduce((prev, instr) -> {
          throw new B5Exception("duplicated reference: " + name);
        })
        .orElseGet(() -> parent.findLinkable(name));
  }

  @Override
  public B5Program getProgram() {
    return parent.getProgram();
  }

  public B5Mark findMark(String name) {
    return walkDown()
        .filter(instr -> instr instanceof B5Mark)
        .map(instr -> (B5Mark)instr)
        .filter(mark -> Objects.equals(mark.name, name))
        .reduce((prev, instr) -> {
          throw new B5Exception("duplicated mark: " + name);
        })
        .orElseThrow(() ->
            new B5Exception("mark not found: " + name)
        );
  }

  public B5Type getReturnType() {
    List<B5Type> returnTypes = walkDown()
        .filter(instr -> instr instanceof B5Return)
        .map(instr -> (B5Return)instr)
        .map(ret -> ret.value.getResultingType())
        .collect(Collectors.toList());

    if (returnTypes.isEmpty()) {
      return null;
    }

    return parent.getProgram().findMostGeneralType(returnTypes);
  }

}
