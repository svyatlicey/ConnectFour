package game;

public class ConnectFour {

    private int[][] board;
    private int currentPlayer = 1;


    public ConnectFour(){
        board = new int[getRows()][getColumns()];
    }

    public int getRows() {
        //todo Реализовать логику возвращения количества строк на поле
        return 6;
    }

    public int getColumns() {
        //todo Реализовать логику возвращение количества столбцов на поле
        return 7;
    }

    /**
     * Возвращает значение в конкретной клетке поля
     * 0 значит пустая, 1 - занята первым игроком, 2 - занята вторым игроком
     * @param row индекс строки
     * @param col индекс столбца
     * @return значение в клетке
     * */
    public int getCell(int row, int col){
        return board[row][col];
    }

    /**
     * Бросает фишку текущего игрока в указанный столбец
     * Фишка падает в самую нижнюю пустую ячейку столбца
     * @param col индекс колонки
     * @throws IllegalStateException если колонка заполнена
     * */
    public void drop(int col) {
        for (int row = getRows()-1; row >= 0; row--) {
            if (board[row][col] == 0) {
                board[row][col] = currentPlayer;
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
                return;
            }
        }
        throw new IllegalStateException("Column is full");
    }

    /**
     * Возвращает текущего игрока (1 или 2)
     * */
    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public boolean checkWin(int player){
        //todo Реализовать логику проверки выигрыша игрока по горизонтали и диагоналям
        // вертикали
        for (int row = 0; row <= getRows() - 4; row++) {
            for (int col = 0; col < getColumns(); col++) {
                if (board[row][col] == player &&
                        board[row+1][col] == player &&
                        board[row+2][col] == player &&
                        board[row+3][col] == player) {
                    return true;
                }
            }
        }
        return false;
    }
}
