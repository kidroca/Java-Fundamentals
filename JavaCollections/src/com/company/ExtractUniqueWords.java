package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * At the first line at the console you are given a piece of text. Extract all words from it and print
 * them in alphabetical order. Consider each non-letter character as word separator. Take the repeating
 * words only once. Ignore the character casing. Print the result words in a single line, separated by spaces
 */
public class ExtractUniqueWords {

    public static void main(String[] args) {
        Scanner scanjo = new Scanner(System.in);

        System.out.print("Give me all the text!: ");
        String[] words = scanjo.nextLine().split("[^A-Za-z]");
        Set<String> distinct = new HashSet<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            distinct.add(word.toLowerCase());
        }

        System.out.printf("Result: %s", String.join(" ", distinct));
    }
}
