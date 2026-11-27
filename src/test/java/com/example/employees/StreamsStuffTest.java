package com.example.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamsStuffTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Exercise 1.9 Streams API
    @Test
    void testStreamOfNullable() {
        Stream<String> stream1 = StreamsStuff.nameStream("1234");
        assertEquals(List.of("1234"), stream1.toList());
        Stream<String> stream2 = StreamsStuff.nameStream(null);
        assertEquals(List.of(), stream2.toList());
    }
}