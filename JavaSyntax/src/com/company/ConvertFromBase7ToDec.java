package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 * Write a program that converts from a base-7 number to its decimal representation
 */
public class ConvertFromBase7ToDec {

    public static void main(String[] args) {
        System.out.print("Enter a base 7 number: ");

        Scanner scanducan = new Scanner(System.in).useLocale(Locale.US);
        String base7num = scanducan.next();

        System.out.println();

        int result = convertFromBase(base7num, 7);
        System.out.printf("Result: %d", result);
    }

    public static int convertFromBase(String number, int base) {
        int result = 0;

        for (int i = number.length() - 1, pow = 0; i >= 0; i--, pow++) {
            int currentDigit = Character.getNumericValue(number.charAt(i));
            result += Math.pow(base, pow) * currentDigit;
        }

        return result;
    }
}
