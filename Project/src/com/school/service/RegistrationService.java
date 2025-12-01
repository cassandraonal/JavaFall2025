package com.school.service;

import com.school.exception.SchoolException;
import com.school.model.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<ClassSession> activeSections;
    private InstructorService instructorService;
    private StudentService studentService;
    private int nextSectionNumber;

    public RegistrationService(InstructorService is, StudentService ss){
        this.instructorService = is;
        this.studentService = ss;
        this.activeSections = new ArrayList<>();
        this.nextSectionNumber = 1;
    }
    public List<Instructor> findEligibleInstructors(Course c){
        List<Instructor> eligible = new ArrayList<>();

        for(Instructor instructor : instructorService.getAllInstructors().values()){
            if(instructor.canTeach(c)){
                eligible.add(instructor);
            }
        }
        return eligible;
    }
    public ClassSession createClassSection(Course c, Instructor i, Classroom r, int capacity)
            throws SchoolException {
        if(!i.canTeach(c)){
            throw new SchoolException("Instructor "+ i.getName() + " is not qualified to teach "+ c.getCourseId());
        }
        if(i.getCurrentLoad() + c.getCredits() > 9){
            throw new SchoolException("Instructor " + i.getName() + " has reached the maximum teaching load (9 credits). Current load: " + i.getCurrentLoad() + " credits");
        }
        ClassSession session = new ClassSession(c, i, r, nextSectionnNumber++, capactiy);
        i.getTeachingAssignment().add(session);
        activeSections.add(session);
        return session;
    }
    public void registerStudent(Student s, ClassSession section) throws SchoolException{
        if(section.isFull()){
            throw new SchoolException("Class is full. Cannot register "+ s.getName());
        }
        int newTotal = s.getCurrentCredits() + section.getCourse().getCredits();
        if(newTotal > 18){
            throw new SchoolException("Registration would exceed maximum semester credits (18). Current: " + s.getCurrentCredits() + " credits");
        }
        if(section.getEnrolledStudents().contains(s)){
            throw new SchoolExceptionn(s.getName() + " is already enrolled in this section");
        }

        section.getEnrolledStudents().add(s);
        s.getEnrolledClasses().add(section);
    }
    public List<ClassSession> getActiveSections(){
        return activeSections;
    }
}