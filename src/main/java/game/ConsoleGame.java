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

    /**
     * Выводит текущее состояние доски в выходной поток.
     * Пустые клетки показываются как '.', фишки первого игрока как 'X', фишки второго как 'O'.
     */
    public void printBoard() {
        out.println();
        out.println("  Доска:");
        for (int r = 0; r < game.getRows(); r++) {
            for (int c = 0; c < game.getColumns(); c++) {
                int cell = game.getCell(r, c);
                char symbol = cell == 0 ? '.' : (cell == 1 ? 'X' : 'O');
                out.print(symbol + " ");
            }
            out.println();
        }
        out.println("0 1 2 3 4 5 6");
    }

    public int promptColumn() {
        while (true) {
            out.print("Ход игрока " + game.getCurrentPlayer() + ". Введите номер столбца (0-6): ");
            if (scanner.hasNextInt()) {
                int col = scanner.nextInt();
                if (col >= 0 && col < game.getColumns()) {
                    return col;
                } else {
                    out.println("Ошибка: столбец вне диапазона.");
                }
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("q")) {
                    return -2;
                }
                out.println("Ошибка: введите число.");
            }
        }
    }

    /**
     * Начинает главный игровой цикл. Выводит доску, запрашивает ходы,
     * обрабатывает выигрыши/ничьи пока игра не завершится.
     */
    public void play() {
        while (true) {
            printBoard();
            int col = promptColumn();
            if (col == -2) {
                out.println("Выход из игры.");
                break;
            }
            game.drop(col);
            if (game.checkWin(1)) {
                printBoard();
                out.println("Игрок 1 победил!");
                break;
            }
            if (game.checkWin(2)) {
                printBoard();
                out.println("Игрок 2 победил!");
                break;
            }
            if (game.isDraw()) {
                printBoard();
                out.println("Ничья!");
                break;
            }
        }
    }

}