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

    @Test
    void testNameToSalary() {
        Main.main(new String[0]);
        int salary = Main.getSalary("Wilma");
        assertEquals(2506, salary);
    }

    @Test
    void testBadNameToSalary() {
        Main.main(new String[0]);
        assertEquals(-1, Main.getSalary("XXX"));
    }

    @Test
    void testSequencedCollections() {
        List<String> words = List.of("one", "one", "two", "three", "four", "five", "five");
        System.out.println(words.getFirst());
        System.out.println(words.getLast());
        SequencedCollection<String> words2 = new LinkedHashSet<>(List.of("one", "one", "two", "three",
                "four", "five", "five"));
        System.out.println(words2);
        System.out.println(words2.getFirst());
        System.out.println(words2.reversed());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.putFirst("z", 0);
        System.out.println(map);
        System.out.println(map.lastEntry());
    }

    //Exercise 3.1 Collections
    @Test
    void testPhoneBook() {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Name1", "12345");
        phoneBook.put("Name2", "22345");
        phoneBook.put("Name3", "32345");
        phoneBook.put("Name4", "42345");
        System.out.println(phoneBook.get("Name1"));
        System.out.println(phoneBook.get("Name5"));
        System.out.println(phoneBook.getOrDefault("Name2", "-1"));
        assertEquals("-1", phoneBook.getOrDefault("Name5", "-1"));
    }

    //Exercise 3.2 Collections
    @Test
    void testThreeOrders() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Name1", 12);
        map1.put("Name2", 234);
        map1.put("Name3", 345);
        System.out.println(map1.entrySet());
        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("Name1", 12);
        map2.put("Name3", 234);
        map2.put("Name2", 345);
        System.out.println(map2.entrySet());
        Map<String, Integer> map3 = new TreeMap<>();
        map3.put("Name1", 12);
        map3.put("Name2", 234);
        map3.put("Name3", 345);
        System.out.println(map3.entrySet());
    }

    //Exercise 3.3 Collections
    @Test
    void testWordCounts() {
        Map<String, Integer> wordsMap = new TreeMap<>();
        String text = "the cat and the hat and the bat";
        String[] words = text.split("\\s+");
        for(String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordsMap);
    }

    //Exercise 3.4 Collections
    @Test
    void testPutVSPutIFAbsent() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Fred", 100);
        Integer retPutVal = map.put("Fred", 200);
        System.out.println(map + " " + retPutVal);

        Map<String, Integer> map2 = new HashMap<>();
        map2.putIfAbsent("Fred", 100);
        retPutVal = map2.putIfAbsent("Fred", 200);
        System.out.println(map2 + " " + retPutVal);
    }

    //Exercise 3.5 Collections
    @Test
    void testEntrySet() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Fred1", 100);
        map1.put("Fred2", 5001);
        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            if(entry.getValue() > 5000) {
                System.out.println(entry);
            }
        }
    }

    //Exercise 3.8 Collections
    @Test
    void testSequencedCollections2() {
        SequencedCollection<String> setOfChars = new LinkedHashSet<>(List.of("c", "a", "c", "b", "a"));
        System.out.println(setOfChars);
        System.out.println(setOfChars.getFirst());
        System.out.println(setOfChars.getLast());
        System.out.println(setOfChars.reversed());
    }

    //Exercise 3.9 Collections
    @Test
    void testSortedFirstAndLast() {
        SequencedCollection<String> setOfChars = new TreeSet<>(List.of("c", "a", "c", "b", "a"));
        System.out.println(setOfChars);
        System.out.println(setOfChars.getFirst());
        System.out.println(setOfChars.getLast());
        System.out.println(setOfChars.reversed());
        //setOfChars.addFirst("z"); // UnsupportedOperationException
        System.out.println(setOfChars);
    }

}