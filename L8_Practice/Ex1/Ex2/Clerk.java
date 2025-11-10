public class Clerk extends Employee{
    private int bonus = 100;
    Clerk(int empid, String n, String d, int s, int l){
        super(empid, n, d, s, l);
    }
    Clerk(){this(0,"uknown","none", 0,0);}
    void display(){
        System.out.println("Employee id: "+getemployeeid());
        System.out.println("Department: "+getDepartment());
        System.out.println("name: "+getName());
        System.out.println("Salary: "+getSalary());
        System.out.println("Bonus per month: "+bonus);
        System.out.println("leave deduction: "+calculate_leave());
    }
}