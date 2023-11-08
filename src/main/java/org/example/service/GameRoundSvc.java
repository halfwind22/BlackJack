package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.entity.Dealer;
import org.example.entity.Deck;
import org.example.entity.User;
import org.example.utils.CardUtils;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Data
@AllArgsConstructor
public class GameRoundSvc {

    Dealer dealer;
    List<User> users;
    Deck deck;

    public void playRound(int round) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("Starting round: " + round);
        System.out.println();
        dealer.clearHand();
        dealer.setCardInHand(CardUtils.drawCardAndUpdateDeck(deck));
        dealer.setCardInHand(CardUtils.drawCardAndUpdateDeck(deck));
        dealer.showHand();
        for (User user : users) {
            user.clearHand();
            int playerSum = 0;
            user.setCardInHand(CardUtils.drawCardAndUpdateDeck(deck));
            user.setCardInHand(CardUtils.drawCardAndUpdateDeck(deck));
            playerSum = user.sumAtHand(user.getHandOfCards());
            user.showHand();
            System.out.println("Player: " + user.getName() + " has a total sum of: " + playerSum + " from the hand");
            if (playerSum == 21) {
                System.out.println("Player: " + user.getName() + " WINS!");
                user.setScore(user.getScore() + 1);
                return;
            } else {
                int dealerSum = dealer.sumAtHand(dealer.getHandOfCards());
                if (dealerSum == 21) {
                    System.out.println("Dealer WINS!");
                    dealer.setScore(dealer.getScore() + 1);
                    return;
                } else {
                    // Neither dealer nor player is 21 yet
                    System.out.println("Wanna HOLD or HIT ???");

                    while (Objects.equals(sc.next(), "HIT")) {
                        user.setCardInHand(CardUtils.drawCardAndUpdateDeck(deck));
                        user.showHand();
                        playerSum = user.sumAtHand(user.getHandOfCards());
                        System.out.println("Player: " + user.getName() + " has a total sum of: " + playerSum + " from the hand");
                        if (playerSum > 21) {
                            System.out.println("Player: " + user.getName() + " is BUSTED!");
                            dealer.setScore(dealer.getScore() + 1);
                            return;
                        } else if (playerSum == 21) {
                            System.out.println("Player: " + user.getName() + " WINS!");
                            user.setScore(user.getScore() + 1);
                            return;
                        }
                    }

                    //At this point the player has chosen STAND
                    while (dealer.sumAtHand(dealer.getHandOfCards()) < 21 || dealer.sumAtHand(dealer.getHandOfCards()) <= user.sumAtHand(user.getHandOfCards())) {
                        dealer.setCardInHand(CardUtils.drawCardAndUpdateDeck(deck));
                        dealer.showHand();
                    }

                    if (dealer.sumAtHand(dealer.getHandOfCards()) > 21) {
                        System.out.println("Dealer is BUSTED!, player: " + user.getName() + " WINS!");
                        user.setScore(user.getScore() + 1);
                        return;
                    } else if (dealer.sumAtHand(dealer.getHandOfCards()) == 21) {
                        System.out.println("Dealer WINS !");
                        dealer.setScore(dealer.getScore() + 1);
                        return;
                    } else if (dealer.sumAtHand(dealer.getHandOfCards()) > user.sumAtHand(user.getHandOfCards())) {
                        System.out.println("Dealer WINS !");
                        dealer.setScore(dealer.getScore() + 1);
                        return;
                    }

                }
            }
        }
    }
}
