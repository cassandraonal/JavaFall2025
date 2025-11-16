package Ex2;
/*
c, Create a Teacher class inherits from Person
Teacher has one extra member variable call subject
Add two arg contructor to Teacher class.
*/
class Teacher extends Person{
    private String subject;
    Teacher(String n, String s){
        super(n);
        subject = s;
    }
    void displayInfo(){
        System.out.print("Teacher name: "+getName());
        System.out.println(", Subject: "+subject);
    }
}