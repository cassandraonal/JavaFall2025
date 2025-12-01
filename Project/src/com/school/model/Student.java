package com.school.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
  private String id;
  private String name;
  private String major;
  private List<ClassSession> enrolledClasses = new ArrayList<>();

  public Student(String id, String name, String major) {
    this.id = id;
    this.name = name;
    this.major = major;
  }

  public String getID() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getMajor() {
    return major;
  }

  public int getCurrentCredits() {
    int total = 0;
    for (ClassSession cs : enrolledClasses) {
      total += cs.getCourse().getCredits();
    }
    return total;
  }

  @Override
  public String toString() {
    return id + " - " + name;
  }
}