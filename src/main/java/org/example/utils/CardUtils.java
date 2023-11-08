package org.example.utils;

import org.example.entity.Deck;
import org.example.enums.Card;
import org.example.enums.Suite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CardUtils {

    public static org.example.entity.Card cardGenerator(Suite suite, Card card) {
        return new org.example.entity.Card(suite, card, card.ordinal() + 1);
    }

    public static Deck deckGenerator(Deck mapDeck) {

        mapDeck.getDeckOfCards().clear();
        Suite[] suites = Suite.values();
        for (Suite suite : suites) {

            Card[] cards = Card.values();
            ArrayList<org.example.entity.Card> listOfCards = new ArrayList<>(13);
            for (Card card : cards) {
                listOfCards.add(CardUtils.cardGenerator(suite, card));
            }
            mapDeck.getDeckOfCards().put(suite, listOfCards);
        }
        return mapDeck;
    }

    public static org.example.entity.Card drawCardAndUpdateDeck(Deck deck) {
        Suite randomSuite = Suite.values()[new Random().nextInt(Suite.values().length)];
        ArrayList<org.example.entity.Card> cardsFromRandomSuite = deck.getDeckOfCards().get(randomSuite);
        int indexOfCardToBePopped = new Random().nextInt(cardsFromRandomSuite.size());
        org.example.entity.Card card = cardsFromRandomSuite.get(indexOfCardToBePopped);
        cardsFromRandomSuite.remove(card);
        return card;
    }

}
