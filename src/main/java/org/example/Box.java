package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Box {

  private String size;

  public static Box makeSpecialBox() {
    return new Box("Special");
  }
}
