package com.example.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Exercise 2.1 Collections
    @Test
    void testListsVSSets() {
        List<String> names1 = new ArrayList<>();
        names1.add("Fred");
        names1.add("Wilma");
        names1.add("Fred");
        names1.add("Barney");
        System.out.println(names1 + " " + names1.size());

        Set<String> names2 = new HashSet<>();
        names2.add("Fred");
        names2.add("Wilma");
        names2.add("Fred");
        names2.add("Barney");
        System.out.println(names2 + " " + names2.size());

        Set<String> names3 = new LinkedHashSet<>();
        names3.add("Fred");
        names3.add("Wilma");
        names3.add("Fred");
        names3.add("Barney");
        System.out.println(names3 + " " + names3.size());

        Set<String> names4 = new TreeSet<>();
        names4.add("Fred");
        names4.add("Wilma");
        names4.add("Fred");
        names4.add("Barney");
        System.out.println(names4 + " " + names4.size());


    }

}