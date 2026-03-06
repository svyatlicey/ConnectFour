package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectFourTest {
    @Test
    void gameCreationTest(){
        ConnectFour game = new ConnectFour();
        assertNotNull(game);
    }

    @Test
    void defaultRowsTest(){
        ConnectFour game = new ConnectFour();
        assertEquals(6,game.getRows());
    }

    @Test
    void defaultColumnsTest(){
        ConnectFour game = new ConnectFour();
        assertEquals(7,game.getColumns());
    }

    @Test
    void initialCellIsZeroTest(){
        ConnectFour game = new ConnectFour();
        for (int i = 0; i < game.getRows(); i++) {
            for (int j = 0; j < game.getColumns(); j++) {
                assertEquals(0,game.getCell(i, j));
            }
        }
    }

    @Test
    void dropPlacesDiscAtBottomTest(){
        ConnectFour game = new ConnectFour();
        game.drop(0);
        assertEquals(1,game.getCell(5,0));
    }

    @Test
    void dropPlacesDiscInCorrectColumnTest(){
        ConnectFour game = new ConnectFour();
        game.drop(3);
        assertEquals(1,game.getCell(5,3));
    }

    @Test
    void currentPlayerStatsWithOneTest(){
        ConnectFour game = new ConnectFour();
        assertEquals(1,game.getCurrentPlayer());
    }

    @Test
    void currentPlayerSwithcesAfterDropTest(){
        ConnectFour game = new ConnectFour();
        game.drop(0);
        assertEquals(2,game.getCurrentPlayer());
    }

    @Test
    void dropInFullColumnThrowsExceptionTest(){
        ConnectFour game = new ConnectFour();
        for (int i = 0; i < game.getRows(); i++) {
            game.drop(0);
        }
        assertThrows(IllegalStateException.class, ()->game.drop(0));
    }

    @Test
    void checkWinReturnsTrueForVerticalLine(){
        ConnectFour game = new ConnectFour();
        for (int i = 0; i < 7; i++) {
            if(game.getCurrentPlayer() == 1){
                game.drop(0);
            }else{
                game.drop(1);
            }
        }
        assertTrue(game.checkWin(1));
    }

    @Test
    void checkWinReturnsFalseWhenNoWin(){
        ConnectFour game = new ConnectFour();
        game.drop(0);
        game.drop(1);
        game.drop(0);
        game.drop(2);
        game.drop(0);
        game.drop(1);
        assertFalse(game.checkWin(1));
    }


}
