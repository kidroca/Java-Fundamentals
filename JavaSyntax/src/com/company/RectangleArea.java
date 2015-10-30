package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 * Write a program that enters the sides of a rectangle (two integers a and b) and calculates and
 * prints the rectangle's area.
 */
public class RectangleArea {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter two sides of an rectangle to calculate area: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();

        double area = calcRectArea(a, b);

        System.out.println();
        System.out.printf("The area is: %.3f", area);
    }

    private static double calcRectArea(double a, double b) {
        double area = a * b;
        return area;
    }
}
