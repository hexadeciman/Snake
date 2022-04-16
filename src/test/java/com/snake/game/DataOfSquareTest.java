package com.snake.game;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class DataOfSquareTest {
    DataOfSquare s;

    @Before
    public void setUp() {
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