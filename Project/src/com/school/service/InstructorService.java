package com.school.service;

import com.school.model.Instructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InstructorService {

    //HashMap to store all instructors where:
    // key = instructor ID (String)
    // value = Instructor object
    private Map<String, Instructor> instructors = new HashMap<>();
    
    public void loadFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {//ensures BufferReader is closed automatically after use

            String line;//variable to store each line read from CSV
            while ((line = br.readLine()) != null) {//loop through each line of CSV until there are no more

                String[] parts = line.split(",");//split the line by commas into an array
                //Extract data from each column
                String id = parts[0];// Instructor ID
                String name = parts[1];// Instructor name
                
                //the third column contains a pipe-delimited list of qualified course IDs
                String[] courseArray = parts[2].split("\\|");// Split by pipe character
                List<String> qualified = Arrays.asList(courseArray);//Convert array to List so it can be used as a List in Instructor

                Instructor inst = new Instructor(id, name, qualified);//Create a new Instructor object using extracted values
                instructors.put(id, inst);// add the instructor object to the HashMap with ID as the key
            }

            System.out.println("Loaded " + instructors.size() + " instructors.");//Print how many instructors were successfully loaded in the terminal

        } catch (IOException e) {
            System.out.println("Error loading instructors: " + e.getMessage());//prints an error message if there was an error catched while loading the csv files
        }
    }

    public Map<String, Instructor> getAllInstructors() {//getter method to return all instructors
        return instructors;
    }

    public Instructor getInstructorByID(String id) {//getter method to return a specific instructor by ID
        return instructors.get(id);// returns the instructor object associated with the key 'id'
    }
}
