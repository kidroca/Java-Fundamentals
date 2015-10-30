package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Write a method that returns the first N odd/even elements from a collection. Return as many as you can.
 */
public class OddOrEvenElements {

    public static void main(String[] args) {
        Scanner bayIvan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a sequence of numbers: ");
        Integer[] numbers = OddAndEvenPairs.toIntArray(bayIvan.nextLine().split(" "));

        System.out.print("Enter command e.g. 'get 3 odd': ");
        String command = bayIvan.nextLine();

        int oddOrEven = command.toLowerCase().contains("even") ? 0 : 1;
        int elementsCount = Integer.parseInt(command.split(" ")[1]);

        List<Integer> extracted = extractOddEvenElements(numbers, elementsCount, oddOrEven);

        System.out.print("Result: ");
        for (Integer number : extracted) {
            System.out.printf("%d ", number);
        }
    }

    private static List<Integer> extractOddEvenElements(Integer[] numbers, int count, int oddOrEven) {
        ArrayList<Integer> extracted = new ArrayList<>();

        for (int i = 0; i < numbers.length && extracted.size() < count; i++) {
            if (numbers[i] % 2 == oddOrEven) {
                extracted.add(numbers[i]);
            }
        }

        return extracted;
    }
}
