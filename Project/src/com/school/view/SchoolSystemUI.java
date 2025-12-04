package com.school.view;

import com.school.model.*;
import com.school.service.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.util.Map;

public class SchoolSystemUI extends JFrame {

    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();
    private InstructorService instructorService = new InstructorService();
    private ClassroomService classroomService = new ClassroomService();
    private RegistrationService registrationService = new RegistrationService();

    private JTable table;
    private DefaultTableModel tableModel;

    public SchoolSystemUI() {
        setTitle("School System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load all CSV data
        loadData();

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton studentBtn = new JButton("Students");
        JButton courseBtn = new JButton("Courses");
        JButton instructorBtn = new JButton("Instructors");
        JButton classroomBtn = new JButton("Classrooms");
        JButton registerBtn = new JButton("Register Student");

        buttonPanel.add(studentBtn);
        buttonPanel.add(courseBtn);
        buttonPanel.add(instructorBtn);
        buttonPanel.add(classroomBtn);
        buttonPanel.add(registerBtn);

        // Table setup
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Button actions
        studentBtn.addActionListener(e -> displayStudents());
        courseBtn.addActionListener(e -> displayCourses());
        instructorBtn.addActionListener(e -> displayInstructors());
        classroomBtn.addActionListener(e -> displayClassrooms());
        registerBtn.addActionListener(e -> registerStudentToCourse());

        // Layout
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void loadData() {
        studentService.loadFromCSV("student.csv");
        courseService.loadFromCSV("course.csv");
        instructorService.loadFromCSV("instructor.csv");
        classroomService.loadFromCSV("classroom.csv");
        registrationService.loadFromCSV("registration.csv"); // optional, load existing registrations
    }

    private void displayStudents() {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Major");

        Map<String, Student> students = studentService.getAllStudents();
        for (Student s : students.values()) {
            tableModel.addRow(new Object[]{s.getId(), s.getName(), s.getMajor()});
        }
    }

    private void displayCourses() {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        tableModel.addColumn("Course ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Credits");

        Map<String, Course> courses = courseService.getAllCourses();
        for (Course c : courses.values()) {
            tableModel.addRow(new Object[]{c.getCourseId(), c.getName(), c.getCredits()});
        }
    }

    private void displayInstructors() {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Qualified Courses");

        Map<String, Instructor> instructors = instructorService.getAllInstructors();
        for (Instructor i : instructors.values()) {
            tableModel.addRow(new Object[]{
                i.getId(),
                i.getName(),
                String.join("|", i.getTeachingAssignment().stream().map(cs -> cs.getCourse().getCourseId()).toList())
            });
        }
    }

    private void displayClassrooms() {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        tableModel.addColumn("Room Number");
        tableModel.addColumn("Has Computer");
        tableModel.addColumn("Has Smartboard");

        Map<String, Classroom> classrooms = classroomService.getAllClassrooms();
        for (Classroom r : classrooms.values()) {
            tableModel.addRow(new Object[]{r.getRoomNumber(), r.hasComputer(), r.hasSmartboard()});
        }
    }

    // === Register student to course ===
    private void registerStudentToCourse() {
        String studentId = JOptionPane.showInputDialog(this, "Enter Student ID:");
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Student not found!");
            return;
        }

        String courseId = JOptionPane.showInputDialog(this, "Enter Course ID to register:");
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            JOptionPane.showMessageDialog(this, "Course not found!");
            return;
        }

        // Create registration
        ClassSession cs = new ClassSession(course);
        registrationService.registerStudent(student, cs);

        // Save to CSV
        saveRegistration(student, cs);

        JOptionPane.showMessageDialog(this, "Student " + student.getName() + " registered to course " + course.getName() + "!");
    }

    private void saveRegistration(Student student, ClassSession cs) {
        try (FileWriter fw = new FileWriter("registration.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            // CSV format: studentId,courseId
            out.println(student.getId() + "," + cs.getCourse().getCourseId());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving registration: " + e.getMessage());
        }
    }

    // Main method to launch GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SchoolSystemUI::new);
    }
}
