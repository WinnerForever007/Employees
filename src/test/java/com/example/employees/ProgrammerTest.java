package com.example.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Exercise 2.4
    @Test
    void testDateFormats() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dob;
        dob = LocalDate.parse("07/04/1776", dtf);
        assertEquals("07/04/1776", dob.format(dtf));

        assertThrows(DateTimeParseException.class, () -> {
            LocalDate.parse("7/4/1776", dtf);
        });
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        assertThrows(DateTimeParseException.class, () -> {
            LocalDate.parse("7/4/1776", dtf2);
        });
    }

    //Exercise 2.10
    @Test
    void testGetGalary() {
        String line = "Brzenk, John, 7/15/1964, Programmer, {locpd=10,yoe=2,iq=100}";
        Programmer programmer = new Programmer(line);
        int salary = programmer.getSalary();
        assertEquals(5000, salary);
    }


}