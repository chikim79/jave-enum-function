package org.example;

public class WrappingUtil {

  public static Box includeBubbleWrap(Box box) {
    box.getSpecialInstructions().add("Bubble wrap");
    return box;
  }

  public static Box addSurvey(Box box) {
    box.getSpecialInstructions().add("Survey");
    return box;
  }

  public static Box addFragileSticker(Box box) {
    box.getSpecialInstructions().add("Fragile sticker");
    return box;
  }

  public static Box addInsurance(Box box) {
    box.getSpecialInstructions().add("Insurance");
    return box;
  }

  public static Box addGiftWrap(Box box) {
    box.getSpecialInstructions().add("Gift wrap");
    return box;
  }
}
