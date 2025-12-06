package com.school.service;

import com.school.model.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CourseService {
    
    //HashMap to store all courses where:
    // key = course ID (String)
    // Value = Course Object
    private Map<String, Course> courses = new HashMap<>();
    
    //Method to load courses from a CSV file
    public void loadFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {//ensures BufferReader is closed automatically after use
            String line;//variable to store each line read from CSV
            while ((line = br.readLine()) != null) {//loop through each line of CSV until there are no more
                String[] parts = line.split(",");//split the line by commas into an array
                //Extract data from each column
                String id = parts[0];// Course ID
                String name = parts[1];// Course name
                int credits = Integer.parseInt(parts[2]);//Converts credits from String to int

                //create a new course object using the extracted values
                Course c = new Course(id, name, credits);
                courses.put(id, c);//add the course object to the HashMap with ID as the key
            }
            System.out.println("Loaded " + courses.size() + " courses.");//print how many courses were successfully loaded
        } catch (IOException e) {//catch any file reading errors
            System.out.println("Error loading courses: " + e.getMessage());//print an error message if there was a problem reading the file
        }
    }

    public Map<String, Course> getAllCourses() {//getter method to return all courses
        return courses;
    }

    public Course getCourse(String id) {//getter method to return a specific course by its ID
        return courses.get(id);//Returns the course object associated with the key 'id'
    }
}
