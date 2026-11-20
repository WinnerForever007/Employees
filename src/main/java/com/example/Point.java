package com.example;

public record Point(int x, int y) {
    //Exercise 4.6
    public Point {
        if(x < 0 || y < 0) {
            throw new IllegalArgumentException("x and y must be >= 0");
        }
    }

    //Exercise 4.7
    public Point(int both) {
        this(both, both);
    }

    //Exercise 4.5
    Point withX(int newX) {
        Point point = new Point(newX, this.y);
        return point;
    }
}
