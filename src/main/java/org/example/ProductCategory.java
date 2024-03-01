package org.example;

import java.util.function.Function;
import java.util.stream.Stream;

public enum ProductCategory {
  SHOES(
      () -> new Box("Small"),
      box -> {
        box.getSpecialInstructions().add("Add silica gel");
        return box;
      }),
  PHONE(Box::makeSpecialBox, WrappingUtil::includeBubbleWrap),
  DOG_TOY(new UltraSpecialBoxSupplier(), WrappingUtil::addSurvey, WrappingUtil::addFragileSticker),
  CHRISTMAS_PRESENT(
      new UltraSpecialBoxSupplier(), WrappingUtil::addGiftWrap, WrappingUtil::addFragileSticker),
  GLASSWARE(() -> new Box("Large"), WrappingUtil::addFragileSticker, WrappingUtil::addInsurance),

  BICYCLE(() -> new Box("Extra Large"));

  final BoxSupplier boxSupplier;

  final Function<Box, Box> wrappingInstruction;

  ProductCategory(BoxSupplier boxSupplier) {
    this(boxSupplier, Function.identity());
  }

  @SafeVarargs
  ProductCategory(BoxSupplier boxSupplier, Function<Box, Box>... wrappingInstructions) {
    this.boxSupplier = boxSupplier;
    this.wrappingInstruction =
        Stream.of(wrappingInstructions).reduce(Function.identity(), Function::andThen);
  }

  public Shipment createShipment() {
    Shipment shipment = new Shipment();
    Box box = boxSupplier.get();
    box = wrappingInstruction.apply(box);
    shipment.setBox(box);
    return shipment;
  }
}
