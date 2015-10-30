package com.company;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a program that takes as input two integers N and M, and randomizes the numbers between them.
 * Note that M may be smaller than or equal to N.
 */
public class RandomizeNumbers {

    public static void main(String[] args) {
        System.out.print("Enter two integer numbers n and m: ");

        Scanner scandal = new Scanner(System.in).useLocale(Locale.US);
        int n = scandal.nextInt(),
                m = scandal.nextInt();

        Integer[] result = getRandomBetween(n, m);
        System.out.println();

        printResult(result);
    }

    private static void printResult(Integer[] result) {
        System.out.print("Result: ");
        for (int number : result) {
            System.out.printf("%d ", number);
        }
    }

    public static Integer[] getRandomBetween(int n, int m) {
        if (n > m) {
            n ^= m;
            m ^= n;
            n ^= m;
        }

        HashSet<Integer> numbers = new HashSet<>();
        int length = m - n + 1;

        while (numbers.size() < length) {
            int number = (int)(Math.random() * (m - n + 1) + n);
            numbers.add(number);
        }

        return numbers.toArray(new Integer[numbers.size()]);
    }
}
