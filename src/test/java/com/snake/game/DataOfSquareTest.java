package com.snake.game;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class DataOfSquareTest {
    DataOfSquare s;

    @BeforeEach
    void setUp() {
        s = new DataOfSquare(0);
    }

    @Test
    public void DefaultColorTest() {
        assertEquals(Color.darkGray, s.getSquare().getColor());
    }

    @Test
    public void MultipleColors() {
        assertEquals(Color.darkGray, s.getSquare().getColor());
        s.lightMeUp(1);
        assertEquals(Color.BLUE, s.getSquare().getColor());
        s.lightMeUp(2);
        assertEquals(Color.white, s.getSquare().getColor());
    }
}