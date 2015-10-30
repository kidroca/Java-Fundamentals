package com.company;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.*;

/**
 * Write a program to find all increasing sequences inside an array of integers. The integers
 * are given in a single line, separated by a space. Print the sequences in the order of their
 * appearance in the input array, each at a single line. Separate the sequence elements by a space.
 * Find also the longest increasing sequence and print it at the last line. If several sequences
 * have the same longest length, print the leftmost of them.
 */
public class LongestIncreasingSequence {

    public static void main(String[] args) {
        Scanner scandocan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a sequence of integers: ");
        List<Integer> ints = Arrays.stream(scandocan.nextLine().split(" "))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());

        printSequences(System.out, ints);
    }

    public static <T extends Comparable> void printSequences(PrintStream output, List<T> elements) {
        int length = 1,
                endIndex = 0,
                maxLength = 1;

        T prevElement = elements.get(0);
        output.printf("%s ", prevElement);

        for (int i = 1; i < elements.size(); i++) {
            if (elements.get(i).compareTo(prevElement) > 0) {
                length++;
                if (length > maxLength) {
                    maxLength = length;
                    endIndex = i;
                }
            } else {
                length = 1;

                output.println();
            }

            prevElement = elements.get(i);
            output.printf("%s ", prevElement);
        }

        output.print("\nLongest: ");
        for (int i = endIndex - maxLength + 1; i <= endIndex; i++) {
            output.printf("%s ", elements.get(i));
        }
    }
}
