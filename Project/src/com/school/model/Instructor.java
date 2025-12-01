package com.school.model;

import java.util.ArrayList;
import java.util.List;

public class Instructor {
  private String id;
  private String name;
  private List<String> qualifiedCourses;
  private List<ClassSession> teachingAssignment = new ArrayList<>();

  public Instructor(String id, String name, List<String> qualifiedCourses) {
    this.id = id;
    this.name = name;
    this.qualifiedCourses = qualifiedCourses;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<ClassSession> getTeachingAssignment() {
    return teachingAssignment;
  }

  public boolean canTeach(Course c) {
    return qualifiedCourses.contains(c.getCourseId());
  }

  public int getCurrentLoad() {
    int total = 0;
    for (ClassSession cs : teachingAssignment) {
      total += cs.getCourse().getCredits();
    }
    return total;
  }

  @Override
  public String toString() {
    return id + " - " + name;
  }
}