package com.company;

import java.io.*;

/**
 * Write a program that reads a text file and prints on the console the sum of the ASCII symbols of each of
 * its lines. Use BufferedReader in combination with FileReader.
 * */
public class SumLines {

    public static void main(String[] args) {
        try(BufferedReader textReader = new BufferedReader(
                new FileReader("lines.txt"))) {

            String currentLine;
            while ((currentLine = textReader.readLine()) != null) {
                int asciSum = sumAsciValues(currentLine);
                System.out.printf("%-100s ASCI Sum = %d", currentLine, asciSum);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found, check the path...");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int sumAsciValues(String currentLine) {
        int sum = 0;
        for (char c : currentLine.toCharArray()) {
            sum += c;
        }

        return sum;
    }
}
