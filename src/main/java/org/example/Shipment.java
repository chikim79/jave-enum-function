package org.example;

import java.math.BigDecimal;

public class Shipment {
  Box box;
  BigDecimal price;

  public Box getBox() {
    return box;
  }

  public void setBox(Box box) {
    this.box = box;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
