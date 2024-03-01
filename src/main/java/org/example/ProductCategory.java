package org.example;

import java.util.function.Supplier;


public enum ProductCategory {

  SHOES(() -> new Box("Small")),
  PHONE(Box::makeSpecialBox),
  DOG_TOY(new UltraSpecialBoxSupplier());

  BoxSupplier boxSupplier;

  ProductCategory(BoxSupplier boxSupplier) {
    this.boxSupplier = boxSupplier;
  }

  public Shipment createShipment() {
    Shipment shipment = new Shipment();
    shipment.setBox(boxSupplier.get());
    return shipment;
  }
}
