package com.snake.game;

import org.junit.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class SquarePanelTest {

    @Test
    public void SquarePanelSetUp() {
        com.snake.game.SquarePanel sp = new com.snake.game.SquarePanel(Color.darkGray);
        assertEquals(Color.darkGray, sp.getColor());
    }
}