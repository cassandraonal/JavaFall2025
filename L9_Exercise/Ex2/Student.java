package Ex2;
/*
b, Create a Student class inherits from Person
Student has one extra member variable call id
Add two arg contructor to Student class.
*/
class Student extends Person{
    private int id;
    Student(String n, int i){
        super(n);
        id = i;
    }
    void displayInfo(){
        System.out.print("Student name: "+getName());
        System.out.println(", ID: "+id);
    }
}