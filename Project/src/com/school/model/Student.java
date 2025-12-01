package com.school.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String id;
    private String name;
    private String major;
    private int currentCredits;
    private List<ClassSession> enrolledClasses;

    public Student(String id, String name, String major, int currentCredits) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.currentCredits = currentCredits;
        this.enrolledClasses = new ArrayList<>();
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public String getMajor() { return major; }

    public int getCurrentCredits() { return currentCredits; }

    public void addCredits(int credits) {
        this.currentCredits += credits;
    }

    public List<ClassSession> getEnrolledClasses() {
        return enrolledClasses;
    }

    @Override
    public String toString() {
        return name + " (" + id + ") - " + major;
    }
}
