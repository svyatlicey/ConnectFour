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
}