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
        assertEquals(0,game.getCell(0,0));
    }

}
