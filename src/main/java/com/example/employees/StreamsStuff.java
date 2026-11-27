package com.example.employees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsStuff {
    static String peopleText = """
            Flintstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flintstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
            Flintstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
            Flintstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
            Flintstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,5=100}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
            Flintstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flintstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
            Flintstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
            Flintstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
            Flintstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;

    public static void main(String[] args) {
        peopleText.lines()
                .map(Employee::createEmployee)
                .forEach(System.out::println);

        Stream.of("a", "b")
                .map(x -> { System.out.println("map " + x); return x; })
                .forEach(x -> System.out.println("print " + x));

        List<String> nums = List.of("one", "two", "three", "four");
        nums.stream()
                .forEach(System.out::println);
        nums.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        nums.stream()
                .map(String::length)
                .forEach(System.out::println);

        Collection<String> nums2 = Set.of("one", "two", "three", "four");

        nums.stream()
                .map(String::hashCode)
                .map(Integer::toHexString)
                .forEach(System.out::println);

        Stream.of("one", "two", "three", "four")
                .map(String::toUpperCase)
                .forEach(System.out::println);

        record Car(String make, String model) {}
        Stream.of(new Car("Ford", "Bronco"), new Car("Tesla", "X"),
                new Car("Tesla", "3"))
                .filter(c -> "Tesla".equals(c.make()))
                .forEach(System.out::println);
        String myVar = null;
        Stream.ofNullable(myVar).forEach(System.out::println);

        IntStream.of(1, 2, 3, 4)
                .forEach(System.out::println);
        IntStream.range(1, 101)
                .forEach(System.out::println);
        IntStream.rangeClosed(1, 40)
                .forEach(System.out::println);
        IntStream.rangeClosed(1, 5)
                .mapToObj(String::valueOf)
                .map(s -> s.concat("-"))
                .forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1, 5)
                .boxed()
                .map(n -> n + "-")
                .forEach(System.out::print);
        System.out.println();

        String[] names = {"Terry", "Sam", "Jake"};
        Arrays.stream(names)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        try(Stream<String> lines = Files
                .lines(Path.of("D:\\Projects\\Employees\\src\\main\\java\\com" +
                        "\\example\\employees\\employees.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Could not read the file: " + e.getMessage());
        }

        //Exercise 1.1 Streams API
        System.out.println("Exercise 1.1 Streams API");
        peopleText.lines()
                .forEach((String s) -> {
                    System.out.println(s);
                });
        peopleText.lines()
                .forEach(s -> System.out.println(s));
        peopleText.lines()
                .forEach(System.out::println);

        //Exercise 1.2 Streams API
        System.out.println("Exercise 1.2 Streams API");
        peopleText.lines()
                .map(Employee::createEmployee)
                .forEach(System.out::println);

        //Exercise 1.4 Streams API
        Stream<String> s = Stream.empty();
        s.count();
        //s.count(); // IllegalStateException

        //Exercise 1.5 Streams API
        System.out.println("Exercise 1.5 Streams API");
        List<String> listExFive = List.of("one", "two", "three", "four", "five");
        listExFive.stream()
                .map(String::length)
                .forEach(System.out::println);
        listExFive.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Exercise 1.6 Streams API
        record Book(String title, int year){};
        Stream.of(new Book("Book1", 1996), new Book("Book2", 1998),
                new Book("Book3", 2001), new Book("Book4", 2003),
                new Book("Book5", 1990))
                .filter(b -> b.year() > 2000)
                .forEach(System.out::println);

        //Exercise 1.7 Streams API
        IntStream.range(10, 21)
                .forEach(System.out::println);
        IntStream.rangeClosed(10, 20)
                .forEach(System.out::println);
        int sum = IntStream.rangeClosed(1, 1000)
                .sum();
        System.out.println(sum);

        //Exercise 1.8 Streams API
        System.out.println("Exercise 1.8 Streams API");
        IntStream.rangeClosed(1, 5)
                .mapToObj(String::valueOf)
                .map(str -> str.concat("-"))
                .forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1, 5)
                .boxed()
                .map(n -> n + "-")
                .forEach(System.out::print);
        System.out.println();



    }

    //Exercise 1.9 Streams API
    public static Stream<String> nameStream(String name) {
        return Stream.ofNullable(name);
    }

}
