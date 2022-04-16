package test.java.com.snake.game;

import com.snake.game.DataOfSquare;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class DataOfSquareTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void DataOfSquareTest() {
        com.snake.game.DataOfSquare s = new com.snake.game.DataOfSquare(0);
        assertEquals(Color.darkGray, s.getSquare().getColor());
    }

    @Test
    public void MultipleColors() {
        com.snake.game.DataOfSquare s = new com.snake.game.DataOfSquare(0);
        assertEquals(Color.darkGray, s.getSquare().getColor());
        s.lightMeUp(1);
        assertEquals(Color.BLUE, s.getSquare().getColor());
        s.lightMeUp(2);
        assertEquals(Color.white, s.getSquare().getColor());
    }
}