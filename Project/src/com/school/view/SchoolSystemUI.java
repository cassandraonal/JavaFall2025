package com.school.view;

private JComboBox<Course> courseComboBox;
private JComboBox<Instructor> instructorComboBox;
private JComboBox<Classroom> classroomComboBox;
private JTextField capacityField;

private JComboBox<Student> studentComboBox;
private JComboBox<ClassSession> sectionComboBox;

public SchoolSystemUI(){
    initializeServices();
    setTitle("School Registration System");
    setSize(1200, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    tabbedPane = new JTabbedPane();

    tabbedPane.addTab("Dashboard" , createDashboardPanel());
    tabbedPane.addTab("Administration" , creeateAdminPanel());
    add(tabbedPane);
}
private void initializeServices(){
    studentService = new StudentService();
    studentService.loadFromCSV("data/students.csv");

    courseService = new CourseService();
    courseService.loadFromCSV("data/courses.csv");

    classroomService = new ClassroomService();
    classroomService.loadFromCSV("data/classrooms.csv");

    instructorService = new InstructorService();
    instructorService.loadFromCSV("data/instuctors.csv");

    registrationService = new RegistrationService(instructorService, StudentService);
}

privte JPanel createDashboardPanel(){
    JPanel panel = new Jpanel(new BorderLayout(10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel titleLabel = new JLabel("Active Class Sections", SwingConstants.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
    panel.add(titleLabel, BorderLayout.NORTH);

    String[] columns = {"Course ID", "Course Name", "Section #", "Instructor", "Room", "Enrolled/Capacity"};
    tableModel = new DefaultTableModel(columns, 0){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    sectionsTable = new JTable(tableModel);
    sectionsTable.setRowHeight(25);
    sectionsTable.getTableHeader().setRecorderingAllowed(false);

    JScrollPane scrollPane = new JScrollPane(sectionsTable);
    panel.add(scrollPane, BorderLayout.CENTER);

    JButton refreshButton = new JButton("Refresh");
    refreshButton.addActionListener(e -> refreshDashboard());

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(refreshButton);
    panel.add(buttonPanel, BorderLayout.SOUTH);

    return panel;
}
private JPanel createAdminPanel(){
    JPanel panel = new JPanel(new GredLayout(2, 1, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    panel.add(createSectionForm());
    panel.add(createRegistrationForm());

    return panel;
}
private JPanel createSectionForm() {
    JPanel panel = new JPanel(new BorderLayout(10, 10));
    panel.setBorder(BorderFactory.createTitledBorder("Create Class Section"));

    JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
    formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel lblCourse = new JLabel("Course:");
    courseComboBox = new JComboBox<>();
    for(Course course: courseService.getAllCourses().values()){
        courseComboBox.addItem(course);
    }

    JLabel lblInstructor = new JLabel("Instructor:");
    instructorComboBox = new JComboBox<>();

    JLabel lblRoom = new JLabel("Classroom:");
    classroomComboBox = new JComboBox<>();
    for(Classroom classroom : classroomService.getAllClassrooms().values()){
        classroomComboBox.addItem(classroom);
    }

    JLabel lblCapacity = new JLabel("Max Capacity:");
    capacityField = new JTextField("30");

    courseComboBox.addActionListener(e -> {
        Course selectedCourse = (Course) courseComboBox.getSelectedItem();
        if(selectedCourse != null){
            updateInstrucctorDropdown(selectedCourse);
        }
    });

    if(courseComboBox.getItemCount() > 0){
        courseComboBox.setSelectedIndex(0);
    }

    formPanel.add(lblCourse);
    formPanel.add(courseComboBox);
    formPanel.add(lblInstructor);
    formPanel.add(instructorComboBox);
    formPanel.add(lblRoom);
    formPanel.add(classroomComboBox);
    formPanel.add(lblCapacity);
    formPanel.add(capacityField);

    JButton btnCreate = new JButton("Create Section");
    btnCreate.addActionListener(e -> createSection());

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(btnCreate);
    formPanel.add(new JLabel());
    formPanel.add(buttonPanel);

    panel.add(formPanel, BorderLayout.CENTER);

    return panel;
}

private JPanel createRegistrationForm() {
    JPanel panel = new JPanel(new BorderLayout(10, 10));
    panel.setBorder(BorderFactory.createTitledBorder("Register Student to Section"));

    JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
    formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel lblStudent = new JLabel("Student: ");
    studentComboBox = new JComboBox<>();
    for (Student student : studentService.getAllStudents().values()) {
        studentComboBox.addItem(Student);
    }

    JLabel lblSection = new JLabel("Section: ");
    sectionComboBox = new JComboBox<>();

    formPanel.add(lblStudent);
    formPanel.add(studentComboBox);
    formPanel.add(lblSection);
    formPanel.add(sectionComboBox);

    JButton btnRegister = new JButton("Register");
    btnRegister.addActionListener(e -> registerStudent());

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(btnRegiste);
    formPanel.add(new JLabel());
    formPanel.add(buttonPanel);

    panel.add(formPanel, BorderLayout.CENTER);

    return panel;

}
private void updateInstructorDropdown(Course selectedCourse){
    instructorComboBox.removeAllItems();

    for(Instructor instructor : registrationService.findEligibleInstructors(selectedCourse)){
        instructorComboBox.addItem(instructor);
    }
    if(instructorComboBox.getItemCount() == 0){
        JOptionPane.showMessageDialog(this,
            "No qualified instructors found for " + selectedCourse.getCourseId(),
            "Warning",
            JOptionPane.WARNING_MESSAGE);
    }
}
private void createSection(){
    try{
        Course selectedCourse = (Course) courseComboBox.getSelectedItem();
        Instructor selectedInstructor = (Instructor) instructorComboBox.getSelectedItem();
        Classroom selectedClassroom = (Classroom) classroomComboBox.getSelectedItem();
        int capactiy = Integer.parseInt(capacityField.getText().trim());

        if(selectedCourse == null || selectedInstructor == null || selectedClassroom == null){
            JOptionPane.showMessageDialog(this,
                "Please select all required fields",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(capacity <=0){
            JOptionPane.showMessageDialog(this,
                "Capacity must be greater than 0",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        ClassSession session = registrationService.createClassSection(
            selectedCourse, selectedInstructor, selectedClassroom, capacity);
        JOptionPane.showMessageDialog(this,
            "Section created successfully!\n" + session.toString(),
            "Success",
            JOptionPane.INFORMATION_MESSAGE);

        refreshDashboard();
        updateSectionDropdown();
    } catch (NumberFormatException ex){
        JOptionPane.showMessageDialog(this,
            "Invalid capacity number",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    } catch (SchoolException ex){
        JOptionPane.showMessageDialog(this,
            ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}
private void registerStudent() {
    try{
        Student selectedStudent = (Student) studentComboBox.getSelectedItem();
        ClassSession selectedSection = (ClassSession) sectionComboBox.getSelectedItem();

        if(selectedStudent == null || selectedSection == null){
            JOptionPane.showMessageDialog(this,
                "Please select both student and section",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        registrationService.registerStudent(selectedStudent, selectedSection);
        JOptionPane.showMessageDialog(this,
            "Student registered successfully!\n" +
            selectedStudent.getName() + " enrolled in " + selectedSection.getCourse().getCourseId(),
            "Success",
            JOptionPane.INFORMATION_MESSAGE);
        refreshDashboard();

    }catch(SchoolException ex){
        JOptionPane.showMessageDialog(this,
            ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

private void refreshDashboard(){
    tableModel.setRowCount(0);

    for(ClassSession session : registrationService.getActiveSections()){
        object[] row = {
            session.getCourse().getCourseId(),
            session.getCourse().getName(),
            session.getSectionNumber(),
            session.getInstructor().getName(),
            session.getClssroom().getRoomNumber(),
            session.getEnrolledStudents().size() + "/" + session.getMaxCapacity()
        };
        tableModel.addRow(row);
    }
}

private void updateSectionDropdown(){
    sectionComboBox.removeAllItems();
    for(ClassSession session : registrationService.getActiveSections()){
        sectionComboBox.addItem(session);
    }
}
