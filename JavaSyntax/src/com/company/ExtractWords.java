package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a program that extracts words from a string. Words are sequences of characters that are
 * at least two symbols long and consist only of English alphabet letters. Use regex.
 */
public class ExtractWords {

    public static void main(String[] args) {
        System.out.print("Enter some text to extract words form: ");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String text = scanner.nextLine();

        Pattern englishWords = Pattern.compile("[a-z]{2,}", Pattern.CASE_INSENSITIVE);
        Matcher macho = englishWords.matcher(text);

        System.out.print("Result: ");
        while (macho.find()) {
            System.out.printf("%s ", macho.group());
        }
    }
}
