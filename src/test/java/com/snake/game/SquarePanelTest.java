package test.java.com.snake.game;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class SquarePanelTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void SquarePanelSetUp() {
        com.snake.game.SquarePanel sp = new com.snake.game.SquarePanel(Color.darkGray);
        assertEquals(Color.darkGray, sp.getColor());
    }
}