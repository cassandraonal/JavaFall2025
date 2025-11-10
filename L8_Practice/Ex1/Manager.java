package L8_Practice.Ex1;
public class Manager extends Employee{
    private int bonus = 300;
    Manager(int empid, String n, String d, int s){
        super(empid, n, d, s);
    }
    Manager(){this(0,"uknown","none", 0);}
    void display(){
        System.out.println("Employee id: "+getemployeeid());
        System.out.println("Department: "+getDepartment());
        System.out.println("name: "+getName());
        System.out.println("Salary: "+getSalary());
        System.out.println("Bonus per month: "+bonus);
    }
}