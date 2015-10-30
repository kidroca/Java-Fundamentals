package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 * Write a method that takes as input two strings of equal length, and returns Boolean if they are
 * exchangeable or not. Exchangeable are words where the characters in the first string can be replaced
 * to get the second string. Example: egg and add are exchangeable, but aabbccbb and nnooppzz are not.
 * (First bb corresponds to oo, but second bb corresponds to zz)
 */
public class MagicExchangeableWords {

    public static void main(String[] args) {
        System.out.print("Enter two words: ");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String wordA = scanner.next(),
                wordB = scanner.next();

        boolean result = areWordsExchangeable(wordA, wordB);

        System.out.println();
        System.out.printf("Result: words are: %s", result ? "exchangeable" : "not exchangeable");
    }

    private static boolean areWordsExchangeable(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (!checkCurrentLettersMatch(a, b, i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkCurrentLettersMatch(String a, String b, int i) {
        char charA = a.charAt(i),
                charB = b.charAt(i);

        int indexA = i,
                indexB = i;

        while(indexA != -1 && indexB != -1) {
            indexA = a.indexOf(charA, indexA + 1);
            indexB = b.indexOf(charB, indexB + 1);

            if (indexA != indexB) {
                return false;
            }
        }

        return true;
    }
}
