package com.greg.playground.generics;


public class Student<T extends Number> {

    private final String name;
    private final int age;
    private final T bestGrade;

    public Student(final String name, final int age, final T bestGrade) {
        this.name = name;
        this.age = age;
        this.bestGrade = bestGrade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public T getBestGrade() {
        return bestGrade;
    }

    @Override
    public String toString() {
        return "Student name: " + name + ", age: " + age + ", best grade: " + bestGrade;
    }
}