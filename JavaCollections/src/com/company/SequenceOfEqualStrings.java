package com.company;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Write a program that enters an array of strings and finds in it all sequences of equal elements.
 * The input strings are given as a single line, separated by a space
 *
 * Write a program that enters an array of strings and finds in it the largest sequence of equal
 * elements. If several sequences have the same longest length, print the leftmost of them.
 * The input strings are given as a single line, separated by a space.
 */
public class SequenceOfEqualStrings {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter some strings: ");
        String[] theStrings = scan.nextLine().split("\\s+");

        printSequencesOfEqualStrings(theStrings);

        System.out.printf("\nLongest Squence: %s", getLongestSequence(theStrings));
    }

    /**
     * Write a program that enters an array of strings and finds in it all sequences of equal elements.
     * The input strings are given as a single line, separated by a space
     * */
    private static void printSequencesOfEqualStrings(String[] strings) {
        String previousElement = strings[0];
        for (String str : strings) {
            if (!str.equals(previousElement)) {
                System.out.println();
                previousElement = str;
            }

            System.out.printf("%s ", str);

        }
    }

    /**
     * Write a program that enters an array of strings and finds in it the largest sequence of equal
     * elements. If several sequences have the same longest length, print the leftmost of them.
     * The input strings are given as a single line, separated by a space.
     * */
    private static List<String> getLongestSequence(String[] strings) {
        String prev = strings[0];
        int length = 1,
                maxLength = 1,
                endIndex = 0;

        for (int i = 1; i < strings.length; i++) {
            if (strings[i].equals(prev)) {
                length++;

                if (length > maxLength) {
                    maxLength = length;
                    endIndex = i;
                }
            } else {
                length = 1;
                prev = strings[i];
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = endIndex - maxLength + 1; i <= endIndex; i++) {
            result.add(strings[i]);
        }

        return result;
    }
}
