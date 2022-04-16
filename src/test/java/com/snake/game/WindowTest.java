package com.snake.game;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class WindowTest {
    Window window;

    @BeforeEach
    public void setUp() {
        window = new Window();
    }

    @Test
    public void testCreation() {
        assertNotNull(window);
        assertTrue(window instanceof Window); // This test, especially this line is pretty unnecessary
    }
}