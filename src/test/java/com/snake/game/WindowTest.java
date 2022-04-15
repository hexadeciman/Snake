package com.snake.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WindowTest {
    Window window;

    @Before
    public void setUp() {
        window = new Window("one");
    }

    @Test
    public void testCreation() {
        assertNotNull(window);
        assertTrue(window instanceof Window); // This test, especially this line is pretty unnecessary
    }
}