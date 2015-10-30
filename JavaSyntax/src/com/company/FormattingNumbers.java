package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 * Write a program that reads 3 numbers: an integer a (0 ? a ? 500), a floating-point b and a
 * floating-point c and prints them in 4 virtual columns on the console. Each column should have a width
 * of 10 characters. The number a should be printed in hexadecimal, left aligned; then the number a
 * should be printed in binary form, padded with zeroes, then the number b should be printed with 2 digits
 * after the decimal point, right aligned; the number c should be printed with 3 digits after the
 * decimal point, left aligned.
 */
public class FormattingNumbers {

    private static Scanner scania = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        System.out.print("Enter an integer between 0 and 500: ");
        int a = scania.nextInt();
        System.out.println();

        System.out.print("Enter two floating point numbers: ");
        double b = scania.nextDouble(),
            c = scania.nextDouble();
        System.out.println();

        System.out.printf(
                "|%-10X|%010d|%10.2f|%-10.3f|",
                a,
                Integer.parseInt(Integer.toBinaryString(a)),
                b,
                c);
    }
}
