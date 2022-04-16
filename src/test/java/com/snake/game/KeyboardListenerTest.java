package com.snake.game;

import org.junit.Test;

import java.awt.Button;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class KeyboardListenerTest {

    @Test
    public void RightFromUp() {
        ThreadsController.snakeDirection1 = 3;
        KeyboardListener k = new KeyboardListener();
        k.keyPressed(new KeyEvent(new Button(), KeyEvent.VK_RIGHT, 100, 0, KeyEvent.VK_RIGHT, (char)39));
        assertEquals(1, ThreadsController.snakeDirection1);
    }

    @Test
    public void RightFromLeft() {
        ThreadsController.snakeDirection1 = 2;
        KeyboardListener k = new KeyboardListener();
        k.keyPressed(new KeyEvent(new Button(), KeyEvent.VK_RIGHT, 100, 0, KeyEvent.VK_RIGHT, (char)39));
        assertEquals(2, ThreadsController.snakeDirection1);
    }

}