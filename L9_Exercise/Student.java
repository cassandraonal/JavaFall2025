abstract class Student extends Person{
    private int id;
    Student(String name,int id){
        super(name);
        this.id = id;
    }
    int getID(){return id;}
    void displayInfo(){
        System.out.println("name of Student: "+getName());
        System.out.println(", ID: "+id);
    }

}
