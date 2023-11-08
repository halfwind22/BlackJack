package org.example.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Dealer implements Player {

    final String name = "DEALER";

    public Dealer(ArrayList<Card> handOfCards) {
        this.handOfCards = handOfCards;
    }

    ArrayList<Card> handOfCards;
    int score;

    @Override
    public void showHand() {
        System.out.println("******** CARDS: Dealer ***********");
        Card card = handOfCards.get(0);
        switch (card.suite) {
            case DIAMOND -> System.out.print("♦️ ");
            case CLUB -> System.out.print("♣️ ");
            case SPADE -> System.out.print("♠️ ");
            case HEART -> System.out.print("♥️ ");
        }
        System.out.println(card.getFaceValue());
        System.out.println();

    }

    public void showAll() {
        System.out.println("******** CARDS: Dealer ***********");
        for (Card card : handOfCards) {
            switch (card.suite) {
                case DIAMOND -> System.out.print("♦️ ");
                case CLUB -> System.out.print("♣️ ");
                case SPADE -> System.out.print("♠️ ");
                case HEART -> System.out.print("♥️ ");
            }
            System.out.println(card.getFaceValue());
            System.out.println();
        }

    }

    @Override
    public void setCardInHand(Card card) {
        handOfCards.add(card);
    }

    @Override
    public void clearHand() {
        handOfCards.clear();
    }
}
