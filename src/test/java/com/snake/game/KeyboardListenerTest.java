package test.java.com.snake.game;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class KeyboardListenerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void RightFromUp() {
        com.snake.game.ThreadsController.directionSnake = 3;
        com.snake.game.KeyboardListener k = new com.snake.game.KeyboardListener();
        k.keyPressed(new KeyEvent(new Button(), KeyEvent.VK_RIGHT, KeyEvent.VK_RIGHT,KeyEvent.VK_RIGHT,KeyEvent.VK_RIGHT));
        assertEquals(1, com.snake.game.ThreadsController.directionSnake);
    }

    @Test
    public void RightFromLeft() {
        com.snake.game.ThreadsController.directionSnake = 2;
        com.snake.game.KeyboardListener k = new com.snake.game.KeyboardListener();
        k.keyPressed(new KeyEvent(new Button(), KeyEvent.VK_RIGHT, KeyEvent.VK_RIGHT,KeyEvent.VK_RIGHT,KeyEvent.VK_RIGHT));
        assertEquals(2, com.snake.game.ThreadsController.directionSnake);
    }

}