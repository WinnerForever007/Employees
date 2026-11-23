package com.example.employees;

//Exercise 5.5
public interface Gardener {
    default String describeSkills() {
        return "Gardener can cook";
    }
}
