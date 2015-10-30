package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 * Write a program that enters 3 points in the plane (as integer x and y coordinates), calculates and prints
 * the area of the triangle composed by these 3 points. Round the result to a whole number. In case the three
 * points do not form a triangle, print "0" as result.
 */
public class TriangleArea {

    static Scanner scancho = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        Point[] points = readInput();

        double result = calcTriangleArea(points);

        System.out.println();
        System.out.printf("Result: %.2f", result);
    }

    private static Point[] readInput() {
        Point[] points = new Point[3];

        for (int i = 0; i < points.length; i++) {
            System.out.printf("Enter two numbers x,y - Point %c: ", ('A' + i));
            double x = scancho.nextDouble();
            double y = scancho.nextDouble();

            points[i] = new Point(x, y);
        }

        return points;
    }

    private static double calcTriangleArea(Point[] points) {
        Point a = points[0],
                b = points[1],
                c = points[2];

        double aX = a.x * (b.y - c.y),
                bX = b.x * (c.y - a.y),
                cX = c.x * (a.y - b.y);

        double area = Math.abs((aX + bX + cX) / 2);

        return area;
    }

}




