package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a program that reads a list of words from the file words.txt and finds the count of vowels
 * (?????? ?????), consonants (????????) and other punctuation marks. Since English is a bit tricky,
 * assume that a, e, i, o, u are vowels and all others are consonants. Punctuation marks are (!,.?).
 * Do not count whitespace.
 */
public class CountCharacterTypes {

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = readSmallTextFile("words.txt");
            Map<String, Integer> dictionary = countCharTypes(lines);
            try (PrintWriter textWriter = new PrintWriter(
                    new FileWriter("count-chars.txt"))
            ) {
                for (String type : dictionary.keySet()) {
                    textWriter.printf("%s: %d", type, dictionary.get(type));
                    textWriter.println();
                }
            }

            System.out.println("Completed successfully! File count-chars.txt is in the project root directory");
        } catch (IOException e) {
            System.err.println("Neshto se pretzaka... Something went pretzack");
        }
    }

    private static Map<String, Integer> countCharTypes(List<String> lines) {
        char[] vowelsChars = {'a', 'e', 'i', 'o', 'u' };
        char[] punctuationChars = { '!','.', '?', ':', ',', ';' };
        Arrays.sort(punctuationChars);

        int vowels = 0,
                consonants = 0,
                punctuations = 0,
                digits = 0;

        for (String line : lines) {
            for(char c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    digits++;
                } else if (Character.isLetter(c)){
                    if (binarySearchChar(vowelsChars, Character.toLowerCase(c))){
                        vowels++;
                    } else {
                        consonants++;
                    }
                } else if (binarySearchChar(punctuationChars, c)) {
                    punctuations++;
                }
            }
        }

        Map<String, Integer> dictionary = new HashMap<>();
        dictionary.put("Vowels", vowels);
        dictionary.put("Consonants", consonants);
        dictionary.put("Punctuation", punctuations);
        dictionary.put("Digits", digits);

        return dictionary;
    }

    private static boolean binarySearchChar(char[] chars, char c) {
        int index = Arrays.binarySearch(chars, c);
        return index >= 0;
    }

    private static List<String> readSmallTextFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(path), Charset.defaultCharset());
    }
}
