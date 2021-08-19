package com.greg.playground.generics;

import java.util.ArrayList;
import java.util.Arrays;


public class Generics {

    public static void main(String[] args) {
        Generics main = new Generics();
        main.execute();
    }

    private void execute() {

        ArrayList<Integer> integerList = new ArrayList<>();
        ArrayList<Double> doubleList = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<Student<Number>> studentList = new ArrayList<>();

        initializeData(integerList, doubleList, nameList, studentList);

        System.out.println("\nInitial data: ");
        showData(integerList);
        showData(doubleList);
        showData(nameList);
        showData(studentList);

        cloneElements(integerList);
        cloneElements(doubleList);
        cloneElements(nameList);
        cloneElements(studentList);

        System.out.println("\nCloned data: ");
        showData(integerList);
        showData(doubleList);
        showData(nameList);
        showData(studentList);

    }

    private void initializeData(ArrayList<Integer> integerList, ArrayList<Double> doubleList,
                                ArrayList<String> nameList, ArrayList<Student<Number>> studentList) {

        integerList.addAll(Arrays.asList(1, 5, 6, 7, 8, 9, 2, 12));

        doubleList.addAll(Arrays.asList(1.6, 5.4, 6.1, 7.9, 8.2, 9.0, 2.7, 12.2));

        nameList.addAll(Arrays.asList("Adam", "Kathy", "Victor", "Joseph", "Ann", "Julia", "Frodo"));

        studentList.add(new Student<>("Peter", 25, 4.5));
        studentList.add(new Student<>("Vicky", 23, 3));
        studentList.add(new Student<>("Chris", 46, 5));
        studentList.add(new Student<>("Orson", 32, 3.5));

    }

    private void showData(ArrayList<?> inputList) {
        System.out.println(inputList);
    }

    private <T> void cloneElements(ArrayList<T> inputList) {

        int listSize = inputList.size();

        T temp;

        for (int i = 0; i < listSize; i++) {
            temp = inputList.get(i);
            inputList.add(temp);
        }
    }
}


