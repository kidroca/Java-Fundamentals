package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Write a program that copies the contents of a .jpg file to another using FileInputStream,
 * FileOutputStream, and byte[] buffer. Set the name of the new file as my-copied-picture.jpg.
 */
public class CopyJpgFile {

    public static void main(String[] args) throws IOException {
        String pathToFile = "gadost.JPG";

        byte[] buffer = new byte[4096];

        System.out.println("Zapochvam...");

        try (FileInputStream input = new FileInputStream(pathToFile)) {
            try (FileOutputStream output = new FileOutputStream("my-copied-picutre.jpg")) {
                int bytesRead,
                        counter = 0;
                while ((bytesRead = input.read(buffer, 0, buffer.length)) != -1) {
                    output.write(buffer, 0, bytesRead);

                    if (counter % 100 == 0) {
                        System.out.print("cyk ");
                    }

                    counter++;
                }

                System.out.println();
            }
        }

        System.out.println("Copied to root project directory!");
    }
}
