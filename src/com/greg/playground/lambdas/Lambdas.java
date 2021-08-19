package com.greg.playground.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;


public class Lambdas {

    public static void main(String[] args) {
        Lambdas main = new Lambdas();
        main.execute();
    }

    private void execute() {

        String text = "That was Gandalf’s mark, of course, and the old man was Gandalf the Wizard, whose fame in the Shire was due mainly to his skill with fires, smokes, and lights. His real business was far more difficult and dangerous, but the Shire-folk knew nothing about it. To them he was just one of the ‘attractions’ at the Party. Hence the excitement of the hobbit-children. ‘G for Grand’ they shouted, and the old man smiled. They knew him by sight, though he only appeared in Hobbiton occasionally and never stopped long; but neither they nor any but the oldest of their elders had seen one of his firework displays — they now belonged to the legendary past.";

        System.out.println("*** Original text: ");
        System.out.println(text);

        System.out.println("\n*** Text without punct. signs:");
        List<String> words = textToWords(text);
        display(words);

        System.out.println("\n\n*** Without words filtered by regex.");
        regexFiltering(words);
        display(words);

        System.out.println("\n\n*** Sorted alphabetically.");
        sortByAlphabet(words);
        display(words);

        System.out.println("\n\n*** Sorted by word length (asc).");
        sortByLength(words);
        display(words);

        System.out.println("\n\n*** Shuffled.");
        randomizeWords(words);
        display(words);
    }

    List<String> textToWords(String text) {
        String regex = "[\\W\\s]+";

        Pattern pattern = Pattern.compile(regex);

        return new ArrayList<>(Arrays.asList(pattern.split(text)));
    }

    private void display(List<String> words) {
        Consumer<String> action = string -> System.out.print(string + " ");
        words.forEach(action);
    }

    private void regexFiltering(List<String> words) {
        Predicate<String> filter = string -> string.matches("^[jcmpi].+");
        words.removeIf(filter);
    }

    private void sortByAlphabet(List<String> words) {
        Comparator<String> compareByAlphabet = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());
        words.sort(compareByAlphabet);
    }

    private void sortByLength(List<String> words) {
        ToIntFunction<String> showLength = String::length;
        Comparator<String> compareByLength = Comparator.comparingInt(showLength);
        words.sort(compareByLength);
    }

    private void randomizeWords(List<String> words) {

        int length = words.size();

        Random random = new Random();

        for (int i = length - 1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            String temp = words.get(i);
            words.set(i, words.get(j));
            words.set(j, temp);
        }
    }

}
