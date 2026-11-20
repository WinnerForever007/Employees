package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Exercise 4.6
    @Test
    void testPointCoordinatesNotNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Point(-3, 1));
    }
}