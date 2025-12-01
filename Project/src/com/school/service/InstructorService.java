package com.school.service;

import com.school.model.Instructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InstructorService {

    private Map<String, Instructor> instructors = new HashMap<>();

    public void loadFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];

                // pipe-delimited list of qualified courses
                String[] courseArray = parts[2].split("\\|");
                List<String> qualified = Arrays.asList(courseArray);

                Instructor inst = new Instructor(id, name, qualified);
                instructors.put(id, inst);
            }

            System.out.println("Loaded " + instructors.size() + " instructors.");

        } catch (IOException e) {
            System.out.println("Error loading instructors: " + e.getMessage());
        }
    }

    public Map<String, Instructor> getAllInstructors() {
        return instructors;
    }

    public Instructor getInstructorByID(String id) {
        return instructors.get(id);
    }
}
