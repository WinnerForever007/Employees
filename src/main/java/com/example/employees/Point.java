package com.example.employees;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Point {
    private int x;
    private int y;

    public static void main(String[] args) {
        //Exercise 2.2, 2.3 Collections
        Set<Point> pointSet = new HashSet<>();
        pointSet.add(new Point(1, 2));
        pointSet.add(new Point(1, 2));
        System.out.println(pointSet + " " + pointSet.size());

        //Exercise 2.4 Collections
        System.out.println(pointSet.contains(new Point(1, 2)));

        //Exercise 2.5 Collections
        Point point = new Point(3, 5);
        pointSet.add(point);
        point.setX(6);
        System.out.println(pointSet.contains(point));

        //Exercise 2.7 Collections
        Set<String> newTree1 = new TreeSet<>();
        newTree1.add("apple");
        newTree1.add("Banana");
        newTree1.add("cherry");
        newTree1.add("Apple");
        System.out.println(newTree1);
        Set<String> newTree2 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        newTree2.add("apple");
        newTree2.add("Banana");
        newTree2.add("cherry");
        newTree2.add("Apple");
        System.out.println(newTree2);

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
