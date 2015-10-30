package com.company.CustomObjectSaver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that saves and loads the information from a custom Object that you have created to a
 * file using ObjectInputStream, ObjectOutputStream. Create a class Course that has a String field containing
 * the name and an integer field containing the number of students attending the course. Set the name of the
 * new file as course.save.
 */

public class SaveCustomObject {

    public static void main(String[] args) throws IOException {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(
                new Course("I love JavaScript", 1000)
        );
        courses.add(
                new Course("I hate Java, just kiddin'", 5)
        );
        courses.add(
                new Course("I love JavaScript", 10000000)
        );

        File coursesFile = new File("course.save");
        coursesFile.createNewFile();

        saveToFile(courses, coursesFile);

        courses = null;

        courses = loadFromFile(coursesFile);

        for (Course corse : courses) {
            System.out.println(corse.toString());
        }
    }

    private static ArrayList<Course> loadFromFile(File coursesFile) throws IOException {
        try (ObjectInputStream input = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(coursesFile))
        )) {
            return (ArrayList<Course>) input.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Nqma takava darjava!");
            return null;
        }
    }

    private static void saveToFile(ArrayList<Course> courses, File saveFile) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(saveFile))
        )){
            output.writeObject(courses);
        }
    }
}
