package com.company;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * Create a method that takes two strings as arguments and returns the sum of their character codes
 * multiplied (multiply str1.charAt (0) with str2.charAt (0) and add to the total sum). Then continue
 * with the next two characters. If one of the strings is longer than the other, add the remaining
 * character codes to the total sum without multiplication.
 */
public class CharacterMultiplier {

    public static void main(String[] args) {
        System.out.print("Enter two strings separated by space: ");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String[] words = scanner.nextLine().split(" ");

        int sum = multiplyCharacter(words[0], words[1]);

        System.out.println();
        System.out.printf("Result: %d", sum);
    }

    private static int multiplyCharacter(String a, String b) {
        int sum = 0;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                sum += a.charAt(i) * b.charAt(i);
        }

        if (a.length() > b.length()) {
            sum += sumRestOfChars(a, b.length());
        } else if (b.length() > a.length()) {
            sum += sumRestOfChars(b, a.length());
        }

        return sum;
    }

    private static int sumRestOfChars(String str, int i) {
        int sum = 0;

        for (int j = i; j < str.length(); j++) {
            sum += str.charAt(j);
        }

        return sum;
    }
}
