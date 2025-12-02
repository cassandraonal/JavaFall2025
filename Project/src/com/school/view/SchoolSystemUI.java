package com.school.view;

import com.school.model.*;
import com.school.service.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SchoolSystemUI extends JFrame {

    private StudentService studentService;
    private CourseService courseService;
    private InstructorService instructorService;
    private ClassroomService classroomService;
    private RegistrationService registrationService;

    private JComboBox<Course> courseComboBox;
    private JComboBox<Instructor> instructorComboBox;
    private JComboBox<Classroom> classroomComboBox;
    private JTextField capacityField;

    private JComboBox<Student> studentComboBox;
    private JComboBox<ClassSession> sectionComboBox;

    private DefaultTableModel tableModel;

    public SchoolSystemUI() {

        // WINDOW SETTINGS
        setTitle("School Registration System");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // LOAD SERVICES
        studentService = new StudentService();
        studentService.loadFromCSV("data/students.csv");

        courseService = new CourseService();
        courseService.loadFromCSV("data/courses.csv");

        classroomService = new ClassroomService();
        classroomService.loadFromCSV("data/classrooms.csv");

        instructorService = new InstructorService();
        instructorService.loadFromCSV("data/instructors.csv");

        registrationService = new RegistrationService(
                instructorService,
                studentService,
                courseService,
                classroomService
        );

        // Initialize sectionComboBox BEFORE GUI is displayed
        sectionComboBox = new JComboBox<>();
        for (ClassSession cs : registrationService.getAllSections().values()) {
            sectionComboBox.addItem(cs);
        }

        // TABS
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Dashboard", createDashboardPanel());
        tabs.add("Administration", createAdminPanel());

        add(tabs);
        setVisible(true);
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columns = {"Course", "Section", "Instructor", "Room", "Enrolled"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table));
        return panel;
    }

    private JPanel createAdminPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(createSectionForm());
        panel.add(createRegistrationForm());
        return panel;
    }

    private JPanel createSectionForm() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        // Courses
        courseComboBox = new JComboBox<>();
        for (Course c : courseService.getAllCourses().values())
            courseComboBox.addItem(c);

        // Instructors
        instructorComboBox = new JComboBox<>();
        for (Instructor i : instructorService.getAllInstructors().values())
            instructorComboBox.addItem(i);

        // Classrooms
        classroomComboBox = new JComboBox<>();
        for (Classroom r : classroomService.getAllClassrooms().values())
            classroomComboBox.addItem(r);

        capacityField = new JTextField("30");

        JButton btn = new JButton("Create Section");
        btn.addActionListener(e -> createSection());

        panel.setBorder(BorderFactory.createTitledBorder("Create Section"));

        panel.add(new JLabel("Course:"));
        panel.add(courseComboBox);
        panel.add(new JLabel("Instructor:"));
        panel.add(instructorComboBox);
        panel.add(new JLabel("Room:"));
        panel.add(classroomComboBox);
        panel.add(new JLabel("Capacity:"));
        panel.add(capacityField);
        panel.add(new JLabel());
        panel.add(btn);

        courseComboBox.addActionListener(e -> updateInstructors());

        return panel;
    }

    private JPanel createRegistrationForm() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Register Student"));

        studentComboBox = new JComboBox<>();
        for (Student s : studentService.getAllStudents().values())
            studentComboBox.addItem(s);

        JButton btn = new JButton("Register");
        btn.addActionListener(e -> registerStudent());

        panel.add(new JLabel("Student:"));
        panel.add(studentComboBox);
        panel.add(new JLabel("Section:"));
        panel.add(sectionComboBox);
        panel.add(new JLabel());
        panel.add(btn);

        return panel;
    }

    private void updateInstructors() {
        Course selected = (Course) courseComboBox.getSelectedItem();
        instructorComboBox.removeAllItems();

        if (selected == null) {
            for (Instructor i : instructorService.getAllInstructors().values()) {
                if (i != null) instructorComboBox.addItem(i);
            }
            return;
        }

        List<Instructor> eligible = registrationService.findEligibleInstructors(selected);
        if (eligible != null) {
            for (Instructor i : eligible) {
                if (i != null) instructorComboBox.addItem(i);
            }
        }
    }

    private void createSection() {
        try {
            Course c = (Course) courseComboBox.getSelectedItem();
            Instructor i = (Instructor) instructorComboBox.getSelectedItem();
            Classroom r = (Classroom) classroomComboBox.getSelectedItem();

            if (c == null || i == null || r == null) {
                JOptionPane.showMessageDialog(this,
                        "Please select a course, instructor, and classroom.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int cap;
            try {
                cap = Integer.parseInt(capacityField.getText());
                if (cap <= 0) throw new NumberFormatException();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this,
                        "Invalid capacity. Enter a positive number.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            ClassSession newSection = registrationService.createClassSection(c, i, r, cap);

            // Add new section to combo box
            if (newSection != null)
                sectionComboBox.addItem(newSection);

            JOptionPane.showMessageDialog(this, "Section Created!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registerStudent() {
        try {
            Student s = (Student) studentComboBox.getSelectedItem();
            ClassSession cs = (ClassSession) sectionComboBox.getSelectedItem();

            if (s == null || cs == null) {
                JOptionPane.showMessageDialog(this,
                        "Please select a student and a section to register.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cs.isFull()) {
                JOptionPane.showMessageDialog(this,
                        "Section is full. Cannot register student.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            registrationService.registerStudent(s, cs);
            JOptionPane.showMessageDialog(this, "Student Registered!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
