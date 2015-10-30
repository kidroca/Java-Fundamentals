package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * Binary search is an algorithm that works on already sorted arrays. Basically, it goes to the middle
 * element and checks it has to continue searching to the left, or to the right. Return the index of
 * the element, or -1, if the element is not found.
 */
public class RecursiveBinarySearch {

    public static void main(String[] args) {
        Scanner javaScript = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter an array of integers: ");
        int[] numbers;
        try {
            numbers = Arrays.stream(javaScript.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
        } catch (NumberFormatException e) {
            numbers = generateRandomSequence(1000000);
        }

        System.out.print("Working with: ");
        if (numbers.length < 1000) {
            for (int n : numbers) {
                System.out.printf("%d ", n);
            }
        } else {
            System.out.print("... Something big");
        }

        System.out.println();
        System.out.print("Enter a value to be searched: ");
        int value = javaScript.nextInt();

        int index = binarySearch(numbers, value);

        System.out.printf("Result: %d", index);
    }

    private static int[] generateRandomSequence(int count) {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            int value = (int)(Math.random() * 100000);
            result[i] = value;
        }

        Arrays.sort(result);

        return result;
    }

    private static int binarySearch(int[] collection, int value) {
        int index = recursiveBinarySearch(collection, value, 0, collection.length - 1, collection.length / 2);
        return index;
    }

    private static int recursiveBinarySearch(int[] collection, int searchedValue, int bottom, int top, int i) {
        int currentValue = collection[i];

        if (currentValue == searchedValue) {
            return i;
        }

        if (bottom >= top) {
            return -1;
        }

        if (currentValue < searchedValue) {
            bottom = i;
            i += (top - bottom + 1) / 2;

            return recursiveBinarySearch(collection, searchedValue, bottom, top, i);
        } else {
            top = i;
            i -= (top - bottom + 1) / 2;

            return recursiveBinarySearch(collection, searchedValue, bottom, top, i);
        }
    }
}
