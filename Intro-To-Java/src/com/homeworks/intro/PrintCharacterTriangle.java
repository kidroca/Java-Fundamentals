package com.homeworks.intro;

import java.util.Scanner;

/**
 * Create a triangle of characters, based on input. Learn about java.util.Scanner and Integer.parseInt().
 * Test your program with integers up to 26. Think why.
 */
public class PrintCharacterTriangle {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = input.nextInt();

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.printf("%c ", 'a' + j);
            }

            System.out.println();
        }

        for (int i = n; i > 0 ; i--) {
            for (int j = i; j >= 2 ; j--) {
                System.out.printf("%c ", 'a' + i - j);
            }

            System.out.println();
        }
    }
}
