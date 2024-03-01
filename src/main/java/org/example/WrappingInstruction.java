package org.example;

@FunctionalInterface
public interface WrappingInstruction {

  Box wrap(Box box);

  default WrappingInstruction andThen(WrappingInstruction after) {
    return (Box from) -> after.wrap(wrap(from));
  }
}
