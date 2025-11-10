package L8_Practice.Ex1;
public class Clerk extends Employee{
    private int bonus = 100;
    Clerk(int empid, String n, String d, int s){
        super(empid, n, d, s);
    }
    Clerk(){this(0,"uknown","none", 0);}
    void display(){
        System.out.println("Employee id: "+getemployeeid());
        System.out.println("Department: "+getDepartment());
        System.out.println("name: "+getName());
        System.out.println("Salary: "+getSalary());
        System.out.println("Bonus per month: "+bonus);
    }
}