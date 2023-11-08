package org.example.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class User implements Player {

    String name;
    ArrayList<Card> handOfCards;
    int score;


    public User(String name, ArrayList<Card> handOfCards) {
        this.handOfCards = handOfCards;
        this.name = name;
    }

    @Override
    public void showHand() {
        System.out.println("******** CARDS: Player " + name + " ***********");
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
