package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Scanner;

/**
 * Write a program that reads a text file and changes the casing of all letters to upper.
 * The file should be overwritten. Use BufferedReader, FileReader, FileWriter, and PrintWriter.
 */
public class AllCapitals {

    public static void main(String[] args) throws IOException {
        File tmp = File.createTempFile("capitalizeNow", null); // using a temp file in case of error
        String originalFileName = "toBeCapitalized.txt"; // insert the filepath here

        try (BufferedReader textReader = new BufferedReader(
                new FileReader(originalFileName))
        ) {
            try (PrintWriter textWriter = new PrintWriter(new FileWriter(tmp))
            ) {
                String currentLine;
                while ((currentLine = textReader.readLine()) != null) {
                    textWriter.println(currentLine.toUpperCase());
                }
            }
        }

        File original = new File(originalFileName);
         if(original.delete()) {
             tmp.renameTo(original);
             System.out.println("Completed, check out the result in the root folder");
         } else {
             System.out.println("Ne stana!");
         }
    }
}
