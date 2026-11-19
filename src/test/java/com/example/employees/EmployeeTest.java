package com.example.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Exercise 3.8
    @Test
    void testCreateEmployee() {
        int salary = 0;
        Employee emp = Employee.createEmployee("Flintstone, Fred, 1/1/1900, " +
                "Programmer, {locpd=2000,yoe=10,iq=140}");
        salary = emp.getSalary();
        assertEquals(2_803_000, salary);
        assertInstanceOf(Programmer.class, emp);
        emp = Employee.createEmployee("Flintstone, Fred, 1/1/1900, " +
                "Programmerzzzz, {locpd=2000,yoe=10,iq=140}");
        salary = emp.getSalary();
        assertEquals(0, salary);
        //assertInstanceOf(Programmer.class, emp);
    }

}