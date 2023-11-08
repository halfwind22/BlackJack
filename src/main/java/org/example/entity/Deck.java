package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import org.example.enums.Suite;

import java.util.ArrayList;
import java.util.Map;


@Data
@AllArgsConstructor
public class Deck {

    Map<Suite, ArrayList<Card>> deckOfCards;


}
