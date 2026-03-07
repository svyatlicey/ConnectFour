package game;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleGame {
    private final ConnectFour game;
    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleGame(InputStream in, PrintStream out, ConnectFour game) {
        this.scanner = new Scanner(in);
        this.out = out;
        this.game = game;
    }

    public void printBoard() {
        //todo реализовать вывод текущего состояния доски
        out.println();
        out.println("  Доска:");
        for (int i = 0; i < 6; i++) {
            out.println(". . . . . . . ");
        }
        out.println("0 1 2 3 4 5 6");
    }
}