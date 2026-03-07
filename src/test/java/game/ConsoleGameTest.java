package game;

import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ConsoleGameTest {
    @Test
    void consoleGameCreationTest() {
        InputStream in = System.in;
        PrintStream out = System.out;
        ConnectFour game = new ConnectFour();
        ConsoleGame consoleGame = new ConsoleGame(in, out, game);
        assertNotNull(consoleGame);
    }
}