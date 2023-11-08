package org.example.entity;

import lombok.AllArgsConstructor;
import org.example.enums.Suite;

@AllArgsConstructor
public class Card {

    Suite suite;
    String faceValue;
    int actualValue;
}
