package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

/**
 * Write a program to enter a number n and n integer numbers and sort and print them.
 * Keep the numbers in array of integers: int[].
 * */
public class SortNumbersArray {

    public static void main(String[] args) {
        Scanner scando = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter number n: ");
        int n = scando.nextInt();

        System.out.print("Enter n integer numbers: ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scando.nextInt();
        }

        System.out.println();

        Arrays.sort(numbers);
        System.out.print("Sorted: ");
        for (int number : numbers) {
            System.out.printf("%d ", number);
        }
    }
}
