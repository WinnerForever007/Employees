package com.example.employees;

//Exercise 5.1
public class Musician implements Performer {
    @Override
    public String play(String song) {
        System.out.println("Song method: " + song);
        return song;
    }


}
