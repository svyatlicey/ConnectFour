package game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
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

    @Test
    void printBoardPrintsBoardWithDiscs() {
        ConnectFour game = new ConnectFour();
        game.drop(0);
        game.drop(1);
        game.drop(0);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(output);
        ConsoleGame consoleGame = new ConsoleGame(System.in, testOut, game);

        consoleGame.printBoard();

        String ls = System.lineSeparator();
        String expected = ls + "  Доска:" + ls +
                ". . . . . . . " + ls +
                ". . . . . . . " + ls +
                ". . . . . . . " + ls +
                ". . . . . . . " + ls +
                "X . . . . . . " + ls +
                "X O . . . . . " + ls +
                "0 1 2 3 4 5 6" + ls;
        assertEquals(expected, output.toString());
    }

    @Test
    void promptColumnReturnsIntegerForValidInput() {
        String input = "3\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(output);
        ConnectFour game = new ConnectFour();
        ConsoleGame consoleGame = new ConsoleGame(testIn, testOut, game);

        int column = consoleGame.promptColumn();

        assertEquals(3, column);
    }

    @Test
    void promptColumnRepeatsUntilNumber() {
        String input = "abc\n3\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(output);
        ConnectFour game = new ConnectFour();
        ConsoleGame consoleGame = new ConsoleGame(testIn, testOut, game);

        int column = consoleGame.promptColumn();

        assertEquals(3, column);
        assertTrue(output.toString().contains("Ошибка: введите число."));
    }

}