package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 * Write a program that reads three floating point numbers from the console and calculates their result with
 * the following formulae:
        ((a2 + b2) / (a2 – b2))(a + b + c) / ?c             (a2 + b2 - c3)(a – b)
 Then calculate the difference between the average of the three numbers and the average of the two formulae.
 Average (a, b, c) – Average (f1, f2)
 */
public class CalculateExpression {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter three numbers: ");
        double a = scan.nextDouble(),
                b = scan.nextDouble(),
                c = scan.nextDouble();

        double f1 = calcF1(a, b, c);
        double f2 = calcF2(a, b, c);

        double avgAbc = (a + b + c) / 3;
        double avgF1F2 = (f1 + f2) / 2;

        System.out.println();
        System.out.printf(
                "F1 Result: %.2f; F2 Result: %.2f Diff: %.2f", f1, f2, Math.abs(avgAbc - avgF1F2));
    }

    private static double calcF1(double a, double b, double c) {
        double aPow = a * a,
            bPow = b * b;

        double primary = (aPow + bPow) / (aPow - bPow);
        double square = (a + b + c) / Math.sqrt(c);
        double result = Math.pow(primary, square);

        return result;
    }

    private static double calcF2(double a, double b, double c) {
        double aPow = a * a,
                bPow = b * b,
                cCube = Math.pow(c, 3);

        double primary = aPow + bPow - cCube;
        double square = a - b;
        double result = Math.pow(primary, square);

        return result;
    }
}
