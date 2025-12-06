package com.school.view;

import com.school.model.*;
import com.school.service.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

//Main GUI class for the School Registraton System
public class SchoolSystemUI extends JFrame {

    //Service classes to manage students, courses, instructors, classrooms, and registrations
    private StudentService studentService;
    private CourseService courseService;
    private InstructorService instructorService;
    private ClassroomService classroomService;
    private RegistrationService registrationService;

   //GUI components for creating sections
    private JComboBox<Course> courseComboBox;//Dropdown for selecting courses
    private JComboBox<Instructor> instructorComboBox;//Dropdown for selecting instructors
    private JComboBox<Classroom> classroomComboBox;
    private JTextField capacityField;//Text field to enter max students

    //GUI components for registering students
    private JComboBox<Student> studentComboBox;//Dropdown for selecting a student
    private JComboBox<ClassSession> sectionComboBox;//Dropdown for selecting a class section

    private DefaultTableModel tableModel; //Model for dashboard table

    //Constructor: runs when we create a new SchoolSystemUI object
    public SchoolSystemUI() {

        // WINDOW SETTINGS
        setTitle("School Registration System");//Set the window title
        setSize(1200, 700);//Set window size (width x height)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close app when window is closed
        setLocationRelativeTo(null); // Center window on screen

        // LOAD DATA SERVICES
        studentService = new StudentService();//Create a student service object
        studentService.loadFromCSV("data/students.csv");//Load student data from CSV file

        courseService = new CourseService();//Create course service object 
        courseService.loadFromCSV("data/courses.csv");//Load sourses from CSV 

        classroomService = new ClassroomService();
        classroomService.loadFromCSV("data/classrooms.csv");

        instructorService = new InstructorService();
        instructorService.loadFromCSV("data/instructors.csv");

        // Create registration service and pass all other services to it
        registrationService = new RegistrationService(
                instructorService,
                studentService,
                courseService,
                classroomService
        );

        // Create TABS for the GUI
        JTabbedPane tabs = new JTabbedPane();//Tabbed pane allows switching between panels
        tabs.add("Dashboard", createDashboardPanel());//Add Dashboard tab
        tabs.add("Administration", createAdminPanel());//Add Administration tab

        add(tabs);//Add the tabs to the main window

        setVisible(true);//Make the window visible
    }

    //Create the dashboard panel (shows all sections in a table)
    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());//Use BoarderLayout for the panel
        String[] columns = {"Course", "Section", "Instructor", "Room", "Enrolled"};//Column names for the table
        tableModel = new DefaultTableModel(columns, 0);// create table model with 0 rows
        JTable table = new JTable(tableModel);//create table using the model
        panel.add(new JScrollPane(table));//add scroll pane so table can scroll
        return panel;//Return the panel to be added to the GUI
    }

    //Create the administration panel (split into 2 forms)
    private JPanel createAdminPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));//Use grid layout: 1 row, 2 columns
        panel.add(createSectionForm());//Left side: create new section form
        panel.add(createRegistrationForm());// Right side: register student form
        return panel;// Return the panel
    }

    //Form for creating a new class section
    private JPanel createSectionForm() {
        JPanel panel = new JPanel(new GridLayout(6, 2));//Grid Layout: 6 rows, 2 columns

        //Course selection dropdown
        courseComboBox = new JComboBox<>();
        for (Course c : courseService.getAllCourses().values())//Loop through all courses
            courseComboBox.addItem(c);// Add each course to dropdown

        //Instructor dropdown (will be updated when course is selected)
        instructorComboBox = new JComboBox<>();

        //Classroom selection dropdown
        classroomComboBox = new JComboBox<>();
        for (Classroom r : classroomService.getAllClassrooms().values())//Loop through all classrooms
            classroomComboBox.addItem(r);//Add each classroom to dropdown

        capacityField = new JTextField("30");// Default capacity is 30 students

        JButton btn = new JButton("Create Section");//Button to create section 
        btn.addActionListener(e -> createSection());//Call createSection() when clicked

        panel.setBorder(BorderFactory.createTitledBorder("Create Section"));//Add a border title

        // Add labels and input fields to the panel
        panel.add(new JLabel("Course:"));
        panel.add(courseComboBox);
        panel.add(new JLabel("Instructor:"));
        panel.add(instructorComboBox);
        panel.add(new JLabel("Room:"));
        panel.add(classroomComboBox);
        panel.add(new JLabel("Capacity:"));
        panel.add(capacityField);
        panel.add(new JLabel());//Empty cell
        panel.add(btn);//Add button

        courseComboBox.addActionListener(e -> updateInstructors());//Update instructor list when course changes

        return panel;//Return the panel
    }

    //Form for registering a student in a section
    private JPanel createRegistrationForm() {
        JPanel panel = new JPanel(new GridLayout(4, 2));// Grid layout: 4 rows, 2 columns
        panel.setBorder(BorderFactory.createTitledBorder("Register Student"));//Border title

        //Student dropdown
        studentComboBox = new JComboBox<>();
        for (Student s : studentService.getAllStudents().values())//Loop through all students
            studentComboBox.addItem(s);// add each student

        //Section dropdown
        sectionComboBox = new JComboBox<>();
        updateSections();//Populate with all active sections

        JButton btn = new JButton("Register");//Button to register student
        btn.addActionListener(e -> registerStudent());//Call registerStudent() when clicked

        // Add labels and input to the panel
        panel.add(new JLabel("Student:"));
        panel.add(studentComboBox);
        panel.add(new JLabel("Section:"));
        panel.add(sectionComboBox);
        panel.add(new JLabel());//Empty cell
        panel.add(btn);// Add button

        return panel;// Return panel
    }

    //Update instructor dropdown based on selected course
    private void updateInstructors() {
        Course selected = (Course) courseComboBox.getSelectedItem();//Get selected course
        instructorComboBox.removeAllItems();//Clear previous instructors

        if (selected == null) {
            // If no course is selected, show all instructors
            for (Instructor i : instructorService.getAllInstructors().values()) {
                instructorComboBox.addItem(i);// Add each instructor
            }
            return;// Exit method
        }

        // Get eligible instructors for the selected course
        List<Instructor> eligible = registrationService.findEligibleInstructors(selected);
        for (Instructor i : eligible) {
            instructorComboBox.addItem(i);//Add only eligible instructors
        }
    }

    //Update section dropdown with all active sections
    private void updateSections() {
        sectionComboBox.removeAllItems();//Clear previous items
        for (ClassSession cs : registrationService.getActiveSections()) {
            sectionComboBox.addItem(cs);// Add each active section
        }
    }
    private void refreshDashboardTable() {
    tableModel.setRowCount(0); // Clear any existing rows

        // Loop through all active class sections
        for (ClassSession cs : registrationService.getActiveSections()) {
            tableModel.addRow(new Object[]{
                cs.getCourse().getName(),
                cs.getSectionNumber(),
                cs.getInstructor().getName(),
                cs.getClassroom().getRoomNumber(),
                cs.getEnrolledStudents().size()
            });
        }
    }
    //Create a new class section when button is clicked
    private void createSection() {
        try {
            Course c = (Course) courseComboBox.getSelectedItem();// Get selected course
            Instructor i = (Instructor) instructorComboBox.getSelectedItem();// Get selected instructor
            Classroom r = (Classroom) classroomComboBox.getSelectedItem();// Get selected room 
            int cap = Integer.parseInt(capacityField.getText());// Get capacity from text field

            registrationService.createClassSection(c, i, r, cap);//Call service to create section

            updateSections();           //Update section dropdown
            refreshDashboardTable();    //Update table to show new section
            
            JOptionPane.showMessageDialog(this, "Section Created!");//Show confirmationn
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);//show error
        }
    }

//Register a student in a section when button is clicked
    private void registerStudent() {
        if (sectionComboBox.getItemCount() == 0) { //If no section exist
            JOptionPane.showMessageDialog(this,
                "You must create a section first!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;// Exit method
        }

        try {
            Student s = (Student) studentComboBox.getSelectedItem();//Get selected student
            ClassSession cs = (ClassSession) sectionComboBox.getSelectedItem();//Get selected section

            if (s == null || cs == null) {//Check if selections are made
                JOptionPane.showMessageDialog(this,
                    "Please select a student and a section to register",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;//Exit method
            }

            registrationService.registerStudent(s, cs);//Register student in section
            refreshDashboardTable();//Update table to show updated enrollment count
            
            JOptionPane.showMessageDialog(this, "Student Registered!");//Show confirmation 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);//Show error if registration fails
        }
    }
}