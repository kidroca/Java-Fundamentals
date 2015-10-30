package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that saves and loads the information from an ArrayList to a file using ObjectInputStream,
 * ObjectOutputStream. Set the name of the new file as doubles.list
 */
public class SaveArrayListDoubles {

    public static void main(String[] args) throws IOException {
        File list = new File("doubles.list");

        ArrayList<Double> doubles = null;
        if (list.exists()) {
            doubles = readListOfDoubles(list);
        }
        else {
            list.createNewFile();
            System.out.println("Initial!");
            doubles = addRandomNumbers(doubles);
        }

        System.out.println("Doubles read: ");
        for (Double d : doubles) {
            System.out.printf("%f, ", d);
        }

        System.out.println();
        doubles = addRandomNumbers(doubles);

        System.out.println("Saving file...");
        saveListToFile(doubles, list);

        System.out.println("Everithing seems to be ok, check the root project folder for doubles.list");
    }

    private static void saveListToFile(ArrayList<Double> doubles, File list) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(list)
                )
        )) {
            output.writeObject(doubles);
        }
    }

    private static ArrayList<Double> addRandomNumbers(ArrayList<Double> doubles) {
        if (doubles == null) {
            doubles = new ArrayList<>();
        }

        System.out.println("Adding numbers: ");
        for (int i = 0; i < 10; i++) {
            double next = Math.random() * 1000;
            doubles.add(next);

            System.out.printf("%f, ", next);
        }

        System.out.println();

        return doubles;
    }

    private static ArrayList<Double> readListOfDoubles(File list) throws IOException {
        ArrayList<Double> doubles = null;

        try (ObjectInputStream input = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(list)
                )
        )) {
            doubles = (ArrayList<Double>) input.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return doubles;
    }
}
