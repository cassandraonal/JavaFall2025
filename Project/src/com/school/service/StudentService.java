package com.school.service;

import com.school.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentService {

    private Map<String, Student> students = new HashMap<>();
    
    public void loadFromCSV(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

        String line;
        int lineNumber = 0;

        while ((line = br.readLine()) != null) {
            lineNumber++;
            String[] parts = line.split(",");

            // Skip lines with fewer than 4 columns
            if (parts.length < 4) {
                System.out.println("Skipping invalid line " + lineNumber + ": " + line);
                continue;
            }

            String id = parts[0];
            String name = parts[1];
            String major = parts[2];
            int currentCredits = Integer.parseInt(parts[3]);

            Student s = new Student(id, name, major, currentCredits);
            students.put(id, s);
        }

        System.out.println("Loaded " + students.size() + " students.");

    } catch (IOException e) {
        System.out.println("Error loading students: " + e.getMessage());
    }
}
   
    public Map<String, Student> getAllStudents() {
        return students;
    }

    public Student getStudentByID(String id) {
        return students.get(id);
    }
}
