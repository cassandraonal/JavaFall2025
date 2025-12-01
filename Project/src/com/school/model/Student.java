package com.school.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String id;
    private String name;
    private int currentCredits;
    private List<ClassSession> enrolledClasses;

    public Student(String id, String name, int currentCredits) {
        this.id = id;
        this.name = name;
        this.currentCredits = currentCredits;
        this.enrolledClasses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentCredits() {
        return currentCredits;
    }

    public void addCredits(int credits) {
        this.currentCredits += credits;
    }

    public List<ClassSession> getEnrolledClasses() {
        return enrolledClasses;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
