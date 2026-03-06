package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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


}
