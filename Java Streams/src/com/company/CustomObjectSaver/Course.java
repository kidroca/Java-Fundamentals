package com.company.CustomObjectSaver;

import java.io.Serializable;

/**
 * Class to be serialized
 */
public class Course implements Serializable {
    private String name;

    private int students;

    public Course(String name, int students) {
        this.setStudents(students);
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudents() {
        return this.students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format("Course name: %s \nStudents count: %d", this.getName(), this.getStudents());
    }
}
