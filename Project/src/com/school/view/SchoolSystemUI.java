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

        courseComboBox = new JComboBox<>();
        for (Course c : courseService.getAllCourses().values())
            courseComboBox.addItem(c);

        instructorComboBox = new JComboBox<>();

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

        sectionComboBox = new JComboBox<>();
        updateSections();

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
            // If no course is selected, show all instructors
            for (Instructor i : instructorService.getAllInstructors().values()) {
                instructorComboBox.addItem(i);
            }
            return;
        }

        List<Instructor> eligible = registrationService.findEligibleInstructors(selected);
        for (Instructor i : eligible) {
            instructorComboBox.addItem(i);
        }
    }

    private void updateSections() {
        sectionComboBox.removeAllItems();
        for (ClassSession cs : registrationService.getActiveSections()) {
            sectionComboBox.addItem(cs);
        }
    }

    private void createSection() {
        try {
            Course c = (Course) courseComboBox.getSelectedItem();
            Instructor i = (Instructor) instructorComboBox.getSelectedItem();
            Classroom r = (Classroom) classroomComboBox.getSelectedItem();
            int cap = Integer.parseInt(capacityField.getText());

            registrationService.createClassSection(c, i, r, cap);

            // Refresh section combo box
            updateSections();

            JOptionPane.showMessageDialog(this, "Section Created!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

private void registerStudent() {
    if (sectionComboBox.getItemCount() == 0) {
        JOptionPane.showMessageDialog(this,
            "You must create a section first!",
            "Error",
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Student s = (Student) studentComboBox.getSelectedItem();
        ClassSession cs = (ClassSession) sectionComboBox.getSelectedItem();

        if (s == null || cs == null) {
            JOptionPane.showMessageDialog(this,
                "Please select a student and a section to register",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        registrationService.registerStudent(s, cs);
        JOptionPane.showMessageDialog(this, "Student Registered!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}