package com.school.service;

import com.school.model.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CourseService {

    private Map<String, Course> courses = new HashMap<>();

    public void loadFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                int credits = Integer.parseInt(parts[2]);

                Course c = new Course(id, name, credits);
                courses.put(id, c);
            }
            System.out.println("Loaded " + courses.size() + " courses.");
        } catch (IOException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }
    }

    public Map<String, Course> getAllCourses() {
        return courses;
    }

    public Course getCourse(String id) {
        return courses.get(id);
    }
}
