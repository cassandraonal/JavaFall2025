abstract class Teacher extends Person{
    private String subject;
    Teacher(String name, String subject){
        super(name);
        this.subject = subject;
    }
    void displayInfo(){
        System.out.println("Name: "+getName());
        System.out.println(", Subject:"+subject);
    }
}
