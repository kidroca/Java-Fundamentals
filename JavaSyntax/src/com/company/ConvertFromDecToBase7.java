package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 * Write a program that takes an integer number and converts it to base-7
 */
public class ConvertFromDecToBase7 {

    public static void main(String[] args) {
        System.out.print("Enter an Ineger number: ");
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        int decNumber = scan.nextInt();
        String base7number = convertToBase(decNumber, 7);

        System.out.println();
        System.out.printf("Result: %s", base7number);
    }

    public static String convertToBase(int number, int base) {
        StringBuilder sb = new StringBuilder();

        if (number < base) {
            return String.valueOf(number);
        }

        while (number >= base) {
            int remainder = number % base;
            sb.append(remainder);

            number /= base;
        }

        sb.append(number);

        return sb.reverse().toString();
    }
}
