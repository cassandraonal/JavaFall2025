package com.school.service;

import com.school.model.Classroom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClassroomService {

    private Map<String, Classroom> classrooms = new HashMap<>();

    public void loadFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String room = parts[0];
                boolean hasComputer = Boolean.parseBoolean(parts[1]);
                boolean hasSmartboard = Boolean.parseBoolean(parts[2]);

                Classroom r = new Classroom(room, hasComputer, hasSmartboard);
                classrooms.put(room, r);
            }

            System.out.println("Loaded " + classrooms.size() + " classrooms.");

        } catch (IOException e) {
            System.out.println("Error loading classrooms: " + e.getMessage());
        }
    }

    public Map<String, Classroom> getAllClassrooms() {
        return classrooms;
    }

    public Classroom getClassroom(String id) {
        return classrooms.get(id);
    }
}
