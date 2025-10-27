public class Person {
    private String name;

    Person(String n){
        name = n;
    }
    Person(){
        this("tbd");
    }
    void display(){
        System.out.println("Name: "+name);
    }
    
}
