package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.Suite;

@Data
@AllArgsConstructor
public class Card {

    Suite suite;
    org.example.enums.Card faceValue;
    int actualValue;
}
