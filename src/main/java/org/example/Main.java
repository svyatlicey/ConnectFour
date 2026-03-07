package org.example;

import game.ConnectFour;
import game.ConsoleGame;

public class Main {
    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        ConsoleGame consoleGame = new ConsoleGame(System.in, System.out, game);
        consoleGame.play();
    }
}