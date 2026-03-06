package game;

public class ConnectFour {

    private int[][] board;

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

    public void drop(int col){
        // todo реализовать логику с броском в определенный столбец.
        board[5][0] = 1;
    }


}
