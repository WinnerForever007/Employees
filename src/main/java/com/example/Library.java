package com.example;

//Exercise 4.1
public class Library {
    private String name;

    public static void main(String[] args) {
        //Exercise 4.2
        Library library = new Library();
        Shelf shelf = library.new Shelf();
        //Exercise 4.3
        Shape shape;
        shape = new Shape() {
            @Override
            public double area() {
                return 42;
            }
        };
        System.out.println(shape.area());

        //Exercise 4.4
        Point point = new Point(3, 3);
        Point point2 = new Point(3, 3);
        System.out.println(point + " " + point.x() + " " + point.y());
        System.out.println(point2 + " " + point2.x() + " " + point2.y());
        System.out.println(point.equals(point2) + " " + (point == point2));
        //Exercise 4.5
        Point point3 = point.withX(5);
        System.out.println(point3);
        //Exercise 4.7
        Point point4 = new Point(8);
        System.out.println(point4);
        //Exercise 4.9
        shape = () -> 42;


    }

    private static class Book {
        Book() {
        }
    }

    private class Shelf {
        Shelf() {
            System.out.println(name);
        }
    }

}
