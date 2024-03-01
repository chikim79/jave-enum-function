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
  GLASSWARE(() -> new Box("Large"), WrappingUtil::addFragileSticker, WrappingUtil::addInsurance);

  BoxSupplier boxSupplier;

  WrappingInstruction wrappingInstruction;

  ProductCategory(BoxSupplier boxSupplier) {
    this(boxSupplier, box -> box);
  }

  ProductCategory(BoxSupplier boxSupplier, WrappingInstruction... wrappingInstructions) {
    this.boxSupplier = boxSupplier;
    this.wrappingInstruction =
        Stream.of(wrappingInstructions).reduce(box -> box, WrappingInstruction::andThen);
  }

  public Shipment createShipment() {
    Shipment shipment = new Shipment();
    Box box = boxSupplier.get();
    box = wrappingInstruction.wrap(box);
    shipment.setBox(box);
    return shipment;
  }
}
