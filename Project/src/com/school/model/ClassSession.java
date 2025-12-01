package com.school.model;

import java.util.ArrayList;
import java.util.List;

public class ClassSession {

  private Course course;
  private Instructor instructor;
  private Classroom classroom;
  private int sectionNumber;
  private int maxCapacity;
  private List<Student> enrolledStudents = new ArrayList<>();

  public ClassSession(Course course, Instructor instructor, Classroom classroom, int sectionNumber, int maxCapacity) {
    this.course = course;
    this.instructor = instructor;
    this.classroom = classroom;
    this.sectionNumber = sectionNumber;
    this.maxCapacity = maxCapacity;
  }

  public Course getCourse() {
    return course;
  }

  public Instructor getInstructor() {
    return instructor;
  }

  public Classroom getClassroom() {
    return classroom;
  }

  public int getSectionNumber() {
    return sectionNumber;
  }

  public int getMaxCapacity() {
    return maxCapacity;
  }

  public List<Student> getEnrolledStudents() {
    return enrolledStudents;
  }

  public boolean isFull() {
    return enrolledStudents.size() >= maxCapacity;
  }

  @Override
  public String toString() {
    return course.getCourseId() + " Sec " + sectionNumber;
  }
}
  