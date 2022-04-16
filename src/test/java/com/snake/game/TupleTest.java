package com.snake.game;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class TupleTest {
    Tuple t;

    @BeforeEach
    void setUp() {
        t = new Tuple(0, 0);
    }

    @Test
    public void TupleInitialize() {
        assertEquals(0, t.getX());
        assertEquals(0, t.getY());
    }

    @Test
    public void TupleChange() {
        t.ChangeData(1,2);
        assertEquals(1, t.getX());
        assertEquals(2, t.getY());
    }
}