package game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
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

    @Test
    void printBoardPrintsEmptyBoard() throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(output);
        ConsoleGame consoleGame = new ConsoleGame(System.in, testOut, new ConnectFour());

        consoleGame.printBoard();

        String ls = System.lineSeparator();
        String expected = ls + "  Доска:" + ls +
                ". . . . . . . " + ls +
                ". . . . . . . " + ls +
                ". . . . . . . " + ls +
                ". . . . . . . " + ls +
                ". . . . . . . " + ls +
                ". . . . . . . " + ls +
                "0 1 2 3 4 5 6" + ls;
        assertEquals(expected, output.toString());
    }

}