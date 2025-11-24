public class Main {
  public static void main(String[] args) {
    Person myObj = new Person();
    //myObj.name = "John";  // error
    //System.out.println(myObj.name); // error
    myObj.setName("John"); // Set the value of the name variable to "John"
    System.out.println(myObj.getName());
  }
}
/*exercise:
create a Person class, which has fname lname age
change lname, fname and age to private
create accessor for lname and fname, age
create mutator for lname and fname, age
test it from tester class

public static void main(String[] args) {
  Person p1 = new Person();
  p1.setLname("John");
  p1.setFname("David");
  p1.setAge(16);
  System.out.println(p1.getFname()+p1.getLname()+p1.getAge());
}
*/
