package com.homeworks.intro;

import java.util.Scanner;

/**
 * Write a program that converts the decimal number system to the ghetto numeral system. In the ghetto,
 * numbers are represented as following: 0 - Gee, 1 - Bro, 2 - Zuz, 3 - Ma, 4 - Duh, 5 - Yo, 6 - Dis, 7 - Hood,
 * 8 - Jam, 9 - Mack;
 */
public class GhettoSystem {

    public static void main(String[] params) {

        String[] ghettoNumbers = {"Gee", "Bro", "Zuz", "Ma", "Duh", "Yo", "Dis", "Hood", "Jam", "Mack"};

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to convert: ");

        String userInput;
        while (!(userInput = input.next()).equals("exit")) {

            for (int i = 0; i < userInput.length(); i++) {
                int currentDigit = Character.getNumericValue(userInput.charAt(i));

                System.out.print(ghettoNumbers[currentDigit]);
            }

            System.out.println();
            System.out.print("Enter another number or 'exit' to exit: ");
        }
    }
}
