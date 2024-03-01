package org.example;



public class UltraSpecialBoxSupplier implements BoxSupplier {

  @Override
  public Box get() {
    // Call special box maker.  create a pretty box
    return new Box("UltraSpecial");
  }
}
