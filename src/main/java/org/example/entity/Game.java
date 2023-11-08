package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.service.GameRoundSvc;
import org.example.utils.CardUtils;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Game {

    int noOfRounds;
    Dealer dealer;
    ArrayList<User> users;
    Deck deck;

    void playRounds() {


        for (int round = 1; round <= noOfRounds; round++) {
            GameRoundSvc gameRoundSvc = new GameRoundSvc(dealer, users, CardUtils.deckGenerator(deck));
            gameRoundSvc.playRound(round);
        }
    }

    void displayScoreBoard(Player player) {
    }

    public void startGame() {
        playRounds();
    }
}
