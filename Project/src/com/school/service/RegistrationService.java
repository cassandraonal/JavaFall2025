package com.school.service;

import com.school.model.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    //List of all active class sections
    // using a list instead of HashMap bc:
    //1. we mostly iterate through all sections.
    //2. order of creation matters.
    //3. we don't need fast key-based lookup here.
    private List<ClassSession> activeSections = new ArrayList<>();

    // references to other services
    private InstructorService instructorService;
    private StudentService studentService;
    private CourseService courseService;
    private ClassroomService classroomService;

    private int nextSectionNumber = 1; // counter for assigning unique section numbers starting at 1
    //constructor to set up services
    public RegistrationService(InstructorService is,
                               StudentService ss,
                               CourseService cs,
                               ClassroomService rs) {

        this.instructorService = is;
        this.studentService = ss;
        this.courseService = cs;
        this.classroomService = rs;
    }

    // returns a list of instructors who are quallified to teach the given course
    public List<Instructor> findEligibleInstructors(Course c) {
        List<Instructor> eligible = new ArrayList<>(); //creating a list to store instructors who can teach this course

        //loop through all instructors in the system
        for (Instructor instructor : instructorService.getAllInstructors().values()) {
            if (instructor.canTeach(c)) { //using canTeach method from instructor class to check eligablility
                eligible.add(instructor);//add to the eligible list
            }
        }
        return eligible;//return the list of instructors who can teach the course
    }

    //create a new class section with all rule checks
    public ClassSession createClassSection(Course c, Instructor i, Classroom r, int capacity)
            throws SchoolException {//method can throw an error if rules are broken(instructor unqualified, class full, or max credits exceeded.)
        //check if the instructor can teach this course
        if (!i.canTeach(c)) {
            //throw an error if instructor is not qualified
            throw new SchoolException("Instructor " + i.getName()
                    + " is not qualified to teach " + c.getCourseId());
        }
        //check if assigning this course would exceed instructor's max teaching load (9 credits)
        if (i.getCurrentLoad() + c.getCredits() > 9) {
            //throw an error if instructor is overloaded
            throw new SchoolException("Instructor " + i.getName()
                    + " has reached the maximum teaching load. Current load: "
                    + i.getCurrentLoad() + " credits.");
        }
        //create a new class section with unique section number
        ClassSession session =
                new ClassSession(c, i, r, nextSectionNumber++, capacity);

        // add this section to the instructor's teaching list
        i.getTeachingAssignment().add(session);

        // Add section to the list of active sections
        activeSections.add(session);

        return session;// return the new class section
    }

    /** Register a student in a class section */
    public void registerStudent(Student s, ClassSession section)
            throws SchoolException {
        // check if the class is full
        //'isFull()' is a method in ClassSession that returns true if the number of enrolled students
        // has reached the class capacity
        if (section.isFull()) {
            throw new SchoolException("Class is full. Cannot register " + s.getName());
        }

        // calculate total credits if this student registers for this course
        // uses functions from the model classes:
        // s.getCurretnCredits() -> Student.java
        // section.getCourse() -> ClassSession.java
        // getCredits() -> Course.java
        int newTotal = s.getCurrentCredits() + section.getCourse().getCredits();
        //check if adding this course exceeds the student's max allowed credits(18)
        if (newTotal > 18) {
            throw new SchoolException("Registration would exceed maximum semester credits (18).");
        }
        //check if the student is already enrolled in this section
        if (section.getEnrolledStudents().contains(s)) {
            throw new SchoolException(s.getName() + " is already enrolled in this section.");
        }

        // Add the student to the section's enrolled list
        //also add the section to the student's enrolled classes list
        section.getEnrolledStudents().add(s);
        s.getEnrolledClasses().add(section);
    }

    /** List of all open sections */
    public List<ClassSession> getActiveSections() {
        return activeSections;
    }
}
