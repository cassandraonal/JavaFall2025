package com.school.service;

import com.school.model.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private List<ClassSession> activeSections = new ArrayList<>();

    private InstructorService instructorService;
    private StudentService studentService;
    private CourseService courseService;
    private ClassroomService classroomService;

    private int nextSectionNumber = 1;

    public RegistrationService(InstructorService is,
                               StudentService ss,
                               CourseService cs,
                               ClassroomService rs) {

        this.instructorService = is;
        this.studentService = ss;
        this.courseService = cs;
        this.classroomService = rs;
    }

    /** Return instructors qualified to teach this course */
    public List<Instructor> findEligibleInstructors(Course c) {
        List<Instructor> eligible = new ArrayList<>();

        for (Instructor instructor : instructorService.getAllInstructors().values()) {
            if (instructor.canTeach(c)) {
                eligible.add(instructor);
            }
        }
        return eligible;
    }

    /** Create a new class section with full rule validation */
    public ClassSession createClassSection(Course c, Instructor i, Classroom r, int capacity)
            throws SchoolException {

        if (!i.canTeach(c)) {
            throw new SchoolException("Instructor " + i.getName()
                    + " is not qualified to teach " + c.getCourseId());
        }

        if (i.getCurrentLoad() + c.getCredits() > 9) {
            throw new SchoolException("Instructor " + i.getName()
                    + " has reached the maximum teaching load. Current load: "
                    + i.getCurrentLoad() + " credits.");
        }

        ClassSession session =
                new ClassSession(c, i, r, nextSectionNumber++, capacity);

        // Update instructor assignment
        i.getTeachingAssignment().add(session);

        // Add section to active list
        activeSections.add(session);

        return session;
    }

    /** Register a student in a class section */
    public void registerStudent(Student s, ClassSession section)
            throws SchoolException {

        if (section.isFull()) {
            throw new SchoolException("Class is full. Cannot register " + s.getName());
        }

        int newTotal = s.getCurrentCredits() + section.getCourse().getCredits();
        if (newTotal > 18) {
            throw new SchoolException("Registration would exceed maximum semester credits (18).");
        }

        if (section.getEnrolledStudents().contains(s)) {
            throw new SchoolException(s.getName() + " is already enrolled in this section.");
        }

        // Add to both sides of relationship
        section.getEnrolledStudents().add(s);
        s.getEnrolledClasses().add(section);
    }

    /** List of all open sections */
    public List<ClassSession> getActiveSections() {
        return activeSections;
    }
}
