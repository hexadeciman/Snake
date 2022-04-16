package test.java.com.snake.game;

import com.snake.game.Tuple;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class TupleTest {

    com.snake.game.Tuple t;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void TupleInitialize() {
        t = new com.snake.game.Tuple(0, 0);
        assertEquals(0, t.getX());
        assertEquals(0, t.getY());
    }

    @Test
    public void TupleChange() {
        t = new com.snake.game.Tuple(0, 0);
        t.ChangeData(1,2);
        assertEquals(1, t.getX());
        assertEquals(2, t.getY());
    }
}