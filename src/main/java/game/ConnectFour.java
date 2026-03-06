package game;

public class ConnectFour {

    public int getRows() {
        //todo Реализовать логику возвращения количества строк на поле
        return 6;
    }

    public int getColumns() {
        //todo Реализовать логику возвращение количества столбцов на поле
        return 7;
    }

    public int getCell(int row, int col){
        //todo реализовать логику возвращения значения в клетке поля
        if(row == 5 && col == 0){
            return 1;
        }
        return 0;

    }

    public void drop(int col){
        // todo реализовать логику с броском в определенный столбец.
    }


}
