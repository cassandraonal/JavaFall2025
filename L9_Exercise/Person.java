abstract class Person{
    private String name;
    Person(String name){this.name = name;}
    Person(){this("TDB");}
    String getName(){return name;}
    abstract void displayInfo();
}
