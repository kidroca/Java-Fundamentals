package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * You are given an array of integers as a single line, separated by a space. Write a program that checks
 * consecutive pairs and prints if both are odd/even or not. Note that the array length should also be
 * an even number
 */
public class OddAndEvenPairs {

    public static void main(String[] args) {
        System.out.print("Enter an array of integers separated by space: ");

        Scanner scanboy = new Scanner(System.in).useLocale(Locale.US);
        Integer[] numbers = toIntArray(scanboy.nextLine().split(" "));
        System.out.println();

        if (numbers.length % 2 != 0) {
            System.out.println("Invalid length");
        } else {
            for (int i = 0; i < numbers.length; i += 2) {
                int a = numbers[i],
                        b = numbers[i + 1];

                if (a % 2 == b % 2) {
                    System.out.printf("%d, %d -> both are %s", a, b, a % 2 == 0 ? "even" : "odd");
                } else {
                    System.out.printf("%d, %d -> different", a, b);
                }

                System.out.println();
            }
        }
    }

    public static Integer[] toIntArray(String[] sequence) {
        List<Integer> numbers = new ArrayList<>();

        for (String num : sequence) {
            numbers.add(Integer.parseInt(num));
        }

        return numbers.toArray(new Integer[numbers.size()]);
    }
}
