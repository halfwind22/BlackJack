package org.example;

import org.example.entity.Dealer;
import org.example.entity.Deck;
import org.example.entity.Game;
import org.example.entity.User;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        InputStream stream;
        ArrayList<User> listOfUsers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            stream = new FileInputStream("src/main/resources/config.yml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Map<String, Object> gameParameterMap = yaml.load(stream);

        for (int i = 0; i < ((Number) gameParameterMap.get("noOfPlayers")).intValue(); i++) {
            System.out.println("Please enter the name for Player " + (i + 1) + " :");
            listOfUsers.add(new User(scanner.next(), new ArrayList<>()));
        }

        Game game = new Game(
                ((Number) gameParameterMap.get("noOfRounds")).intValue(),
                new Dealer(new ArrayList<>()), listOfUsers, new Deck(new HashMap<>()));
        game.startGame();
    }
}