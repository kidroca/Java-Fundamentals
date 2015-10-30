package com.company;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Write a program to find the most frequent word in a text and print it, as well as how many times it
 * appears in format "word -> count". Consider any non-letter character as a word separator. Ignore the
 * character casing. If several words have the same maximal frequency, print all of them in alphabetical order.
 */
public class MostFrequentWord {

    public static void main(String[] args) {
        Scanner scania = new Scanner(System.in);

        System.out.println("Enter some words");
        String[] words = scania.nextLine().split("[^A-Za-z]");

        List<Pair<String, Integer>> mostRepeatedWord = getMostRepeatedWord(words);

        mostRepeatedWord.forEach(
                pair -> System.out.printf("%s -> %d\n", pair.getKey(), pair.getValue()));
    }

    private static List<Pair<String, Integer>> getMostRepeatedWord(String[] strings) {
        List<Pair<String, Integer>> words = Arrays.stream(strings)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.groupingBy(s -> s.toLowerCase()))
                .values().stream()
                .sorted((a, b) -> b.size() - a.size())
                .map(list -> new Pair<>(list.get(0).toLowerCase(), list.size()))
                .collect(Collectors.toList());

        List<Pair<String, Integer>> top = words.stream()
                .filter(r -> r.getValue() == words.get(0).getValue())
                .sorted((x, y) -> x.getKey().compareTo(y.getKey()))
                .collect(Collectors.toList());

        return top;
    }
}
