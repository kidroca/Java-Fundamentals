package com.homeworks.intro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Create a method that finds the average of three numbers. Read in internet about java methods.
 * Check the naming conventions. Invoke your method and test it. Format the output to two digits after
 * the decimal separator. The placeholder is %.2f
 */
public class GetAverage {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<Double> numbers = new ArrayList<>();

        System.out.print("Enter some numbers: ");
        String userInput = input.nextLine();

        Scanner parser = new Scanner(userInput);
        parser.useLocale(Locale.US);
          while (parser.hasNext()) {
            numbers.add(parser.nextDouble());
          }

        double average = getAverage(numbers);

        System.out.printf("Average is %.2f", average);
    }

    private static double getAverage(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }

        return sum / numbers.size();
    }
}
