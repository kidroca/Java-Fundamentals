package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Write a program that reads three txt files words.txt, count-chars.txt and lines.txt and create
 * a zip archive named text-files.zip. Use FileOutputStream, ZipOutputStream, and FileInputStream.
 */
public class CreateZipArchive {

    public static void main(String[] args) throws IOException {

        try (ZipOutputStream zipOutput = new ZipOutputStream(
                new FileOutputStream("text-files.zip")
        )) {
            List<File> files = new ArrayList<>();
            files.add(new File("words.txt"));
            files.add(new File("count-chars.txt"));
            files.add(new File("lines.txt"));

            for (File f : files) {
                if (f.exists()) {
                    addFileToArchive(f, zipOutput);
                }
            }
        }

        System.out.println("All done! Check root project folder");
    }

    private static void addFileToArchive(File file, ZipOutputStream zipOutput) {
        try {
            zipOutput.putNextEntry(new ZipEntry(file.getName()));
            try (FileInputStream input = new FileInputStream(file)
            ){
                byte[] buffer = new byte[1024];

                int bytesRead;
                while ((bytesRead = input.read(buffer, 0, buffer.length)) > 0) {
                    zipOutput.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            System.err.printf("Master... I have failed you on this file: %s\n", file.getName());
            System.err.println(e.getMessage());
        }
    }
}
