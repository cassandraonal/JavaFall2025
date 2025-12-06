package com.school.service;

import com.school.model.Classroom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClassroomService {
    //This HashMap stores all classrooms where:
    // key = classroom ID (String)
    // Value = Classroom object
    private Map<String, Classroom> classrooms = new HashMap<>();
    //method to load classrooms from csv file
    public void loadFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { //ensures BufferReader is closed automatically after use

            String line;//variable to store each line read from CSV
            while ((line = br.readLine()) != null) {//loop through each line of CSV until there are no more

                String[] parts = line.split(",");//split the line by commas into an array
                //Extract data from each column
                String room = parts[0];//Classroom ID or name
                boolean hasComputer = Boolean.parseBoolean(parts[1]);//convert "true"/"false" to boolean
                boolean hasSmartboard = Boolean.parseBoolean(parts[2]);

                //create a new classroom object using the extracted values
                Classroom r = new Classroom(room, hasComputer, hasSmartboard);
                classrooms.put(room, r);//add the classroom object to the hashmap with room as the key
            }
            //print how many classrooms where sucessfully loaded
            System.out.println("Loaded " + classrooms.size() + " classrooms.");

        } catch (IOException e) { // catch any file reading errors
            System.out.println("Error loading classrooms: " + e.getMessage());//print error message if error found
        }
    }

    public Map<String, Classroom> getAllClassrooms() {//getter method to return all classsrooms
        return classrooms;
    }

    public Classroom getClassroom(String id) {//geter method to return a specific classroom by its ID
        return classrooms.get(id);//returns the classroom object associated with the key 'id'
    }
}
