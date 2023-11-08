package org.example.entity;

import java.util.ArrayList;

public interface Player {
    default int sumAtHand(ArrayList<Card> cards) {
        int sum = 0;
        Card temp = null;
        for (Card card : cards) {
            if (card.getFaceValue() == org.example.enums.Card.ACE) {
                temp = card;
            } else if ((card.getFaceValue() == org.example.enums.Card.JACK) || (card.getFaceValue() == org.example.enums.Card.QUEEN) || (card.getFaceValue() == org.example.enums.Card.KING)) {
                sum += 10;
            } else {
                sum += card.getActualValue();
            }
        }
        if (sum == 10 && temp != null) {
            return 21;
        } else if (sum > 10 && temp != null) {
            return sum + 1;
        } else if (sum < 10 && temp != null) {
            return sum + 11;
        }
        return sum;
    }

    void showHand();

    void setCardInHand(Card card);

    void clearHand();
}
