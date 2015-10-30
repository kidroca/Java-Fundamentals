package com.homeworks.intro;

import java.util.Scanner;

/**
 *  Create a Java program that reads a number N from the console and calculates
 *  the sum of all numbers from 1 to N (inclusive).
 */
public class SumNumberToN {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = input.nextInt(),
                sum = 0;

        for (int i = 1; i <= n ; i++) {
            sum += i;
        }

        System.out.printf("Result: %s", sum);
    }
}
