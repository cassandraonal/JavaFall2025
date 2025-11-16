package Ex2;
abstract class Person{
    private String name;
    Person(String n){name = n;}
    String getName(){return name;}
    abstract void displayInfo();
}