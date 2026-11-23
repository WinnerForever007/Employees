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

    //Exercise 5.2
    @Test
    void testPerformerVariable() {
        Performer programmer = new Programmer("Brzenk, John, 7/15/1964, Programmer, " +
                "{locpd=10,yoe=2,iq=100}");
        assertEquals("song1", programmer.play("song1"));
    }

    //Exercise 5.5
    @Test
    void testChefOrGardenerDescribeSkills() {
        Programmer prog = new Programmer("Brzenk, John, 7/15/1964, Programmer, " +
                "{locpd=10,yoe=2,iq=100}");
        assertEquals("Can cook", prog.describeSkills());
    }

    //Exercise 5.8
    @Test
    void testPatternMatching() {
        Object employee = new Programmer("Brzenk, John, 7/15/1964, Programmer, " +
                "{locpd=10,yoe=2,iq=100}");
        if(employee instanceof Programmer) {
            Programmer programmer = (Programmer) employee;
            System.out.println(programmer.getClass());
        }
        if(employee instanceof Programmer programmer2) {
            System.out.println(programmer2.getClass());
        }

        switch(employee) {
            case Programmer prog -> System.out.println(prog.getClass());
            default -> System.out.println("Default case");
        }
    }

    //Exercise 5.9
    @Test
    void testRecordPatterns() {
        Object employee = new ProgrammerRecord("John", "Brzenk", 10, 12, 100);
        String grade = switch(employee) {
            case ProgrammerRecord(_, _, _, int yoe, _) when yoe >= 10 -> "Senior";
            case ProgrammerRecord _ -> "Junior";
            default -> "Unknown";
        };
        System.out.println(grade);

    }

}