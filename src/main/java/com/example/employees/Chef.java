package com.example.employees;

public interface Chef {
    default void cook(String food) {
        System.out.println("I am now cooking " + food);
    }

    default String cleanUp() {
        return "I'm done cleaning up";
    }

    default String describeSkills() {
        return "Can cook";
    }
}
