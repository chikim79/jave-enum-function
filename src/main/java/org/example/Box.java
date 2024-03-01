package org.example;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Box {

  private String size;

  private List<String> specialInstructions = new ArrayList<>();

  public Box(String size) {
    this.size = size;
  }

  public static Box makeSpecialBox() {
    return new Box("Special");
  }
}
