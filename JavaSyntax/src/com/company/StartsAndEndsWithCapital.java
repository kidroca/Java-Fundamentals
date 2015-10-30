package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a program that takes as input an array of strings are prints only the words that start
 * and end with capital letter. Words are only strings that consist of English alphabet letters. Use regex.
 */
public class StartsAndEndsWithCapital {

    public static void main(String[] args) {
        System.out.print("Enter some text to extract words form: ");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String text = scanner.nextLine();

        Pattern englishWords = Pattern.compile("\\b[A-Z][A-Za-z]*[A-Z]\\b");
        Matcher macho = englishWords.matcher(text);

        System.out.print("Result: ");
        while (macho.find()) {
            System.out.printf("%s ", macho.group());
        }
    }
}
