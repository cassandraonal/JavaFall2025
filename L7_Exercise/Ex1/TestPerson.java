public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setLname("John");
        p1.setFname("David");
        p1.setAge(16);
        Person.updateCountry("Canada");
        System.out.println(p1.getFname()+p1.getLname()+p1.getAge());
        System.out.println(p1.country);
    }
}
