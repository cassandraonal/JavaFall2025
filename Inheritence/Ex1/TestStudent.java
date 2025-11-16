import Ex2.Person;

public class TestStudent {
    public static void main(String args[]){
        Student s = new Student();
        s.display();
        Student s1 = new Student("David",12345678);
        Person p = new Person("Tom");
        p.display();
    }
}
