package com.school.service;

import com.school.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentService {

    private Map<String, Student> students = new HashMap<>(); //Stores all students keyed by their ID for fast lookup
    
   public void loadFromCSV(String filename) { //load csv file
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

        String line;
        int lineNumber = 0;
        //read each line in the csv file
        while ((line = br.readLine()) != null) {
            lineNumber++; // ex. 1001,John Smith, Computer Science
            String[] parts = line.split(","); //split the line by commas

            // Skip completely empty lines
            if (parts.length < 3) {
                System.out.println("Skipping invalid line " + lineNumber + ": " + line);
                continue;
            }
            //                                                                  0        1              2
            //Extract fields from the csv, turns the test line into an array: "1001"  "John Smith"  "Comp Science"
            String id = parts[0]; // 1001  Student ID field
            String name = parts[1]; // John Smith  student name field
            String major = parts[2]; // Computer Science  student major field

            //Default credits to 0 if missing
            int currentCredits = 0; // assume student has 0 credits, bc csv may not include credits or data might be invalid
            if (parts.length >= 4 && !parts[3].isEmpty()) {//the csv row has at least 4 columns, the credit value would be at index 3 if existing
                try {
                    currentCredits = Integer.parseInt(parts[3]); //try converting text to a number 12, 0-->good. abc, eight,3.5->bad and will go to catch
                } catch (NumberFormatException e) {
                    System.out.println("Invalid credits on line " + lineNumber + ", defaulting to 0.");//if credit not there, defaults to 0 printing this.
                }
            }

            Student s = new Student(id, name, major, currentCredits); //passes the values id(from parts[0],name from parts[1],etc.currentCredits,from above keeping safely at 0 if not there at index 3.)
            students.put(id, s);//puts student in a hashmap using their id as the key. allows students.get("100")
        }

        System.out.println("Loaded " + students.size() + " students.");//prints the total number of valid students added to the system

    } catch (IOException e) {
        System.out.println("Error loading students: " + e.getMessage());//only runs if something goes wrong inside the try part
    }
}

   
    public Map<String, Student> getAllStudents() {//returns the entire HashMap of students, useful for GUI
        return students;
    }

    public Student getStudentByID(String id) {
        return students.get(id);
    }
}

//hashmap instead of a list because sometimes i want all students, one student by ID,
// to check count, and to loop over values. HashMap is also useful for GUI to be able
// to populate dropdowns or iterate through all student objects. .get(key) is instant lookup.
// not requiring to search through a whole list.
