public class Student extends Person {
    private int id;

    Student(String n, int i){
        super(n);
        id = i;
    }
    Student(){
        this("tbd", 0);
        //second way:
        //super();
        //id = 0;
    }
    void display(){
        super.display();
    }
}
