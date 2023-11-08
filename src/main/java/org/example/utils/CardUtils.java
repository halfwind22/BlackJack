package org.example.utils;

import org.example.entity.Deck;
import org.example.enums.Card;
import org.example.enums.Suite;

import java.util.ArrayList;
import java.util.Map;

public class CardUtils {

    public static org.example.entity.Card cardGenerator(Suite suite, Card card) {
        return new org.example.entity.Card(suite, card.name(), card.ordinal() + 1);
    }

    public static Deck deckGenerator(Map<Suite, ArrayList<org.example.entity.Card>> mapDeck) {

        Suite[] suites = Suite.values();
        for (Suite suite : suites) {

            Card[] cards = Card.values();
            ArrayList<org.example.entity.Card> listOfCards = new ArrayList<>(13);
            for (Card card : cards) {
                listOfCards.add(CardUtils.cardGenerator(suite, card));
            }
            mapDeck.put(suite, listOfCards);
        }
        return new Deck(mapDeck);
    }
}
