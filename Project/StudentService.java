package com.school.service;

import com.school.model.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Exception;
import java.util.HashMap;
import java.util.Map;

public class StudentService{
    private Map<String, Student> students;
    public StudentsService() {
        students = new HashMap<>();
    }
    public void loadFromCSV(String filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath)){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length == 3){
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String major = parts[2].trim();

                    Student student = new Student(id, name, major);
                    students.put(id, student);
                }
            }
            System.out.println("Loaded " + students.size() + " students.");
        } catch(IOException e){
            System.err.println("Error loading students: " + e.getMessage());
        }
    }
    public Student getStudentByID(String id){
        return students.get(id);
    }
    public Map<String, Student> getAllStudents(){
        return students;
    }
}