class Course{
    private String name;
    private int id;
    private char gpa;
    private int midterm;
    private int finalexam;
    Course(String n, int i, int m, int f){
        name = n;
        id = i;
        midterm = m;
        finalexam = f;
        double score = midterm * 0.4 + finalexam * 0.6;
        if(score >= 90) gpa = 'A';
        else if(score >= 80) gpa = 'B';
        else if(score >= 70) gpa = 'C';
        else gpa = 'F';
    }
    void display(){
        System.out.println("Name"+name+", ID:"+id+", Midterm:"+midterm+", Final:"+finalexam+", GPA:"+gpa);
    }
}