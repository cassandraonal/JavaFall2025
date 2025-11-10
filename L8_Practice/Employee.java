public class Employee {
    private int employeeid;
    private String name;
    private  String department;
    private int salary;
    private int bonus = 200;
    Employee(int empid, String n, String d, int s){
        employeeid = empid;
        name = n;
        department = d;
        salary = s;
    }
    Employee(){this(0,"uknown","none", 0);}
    void display(){
        System.out.println("Employee id: "+employeeid);
        System.out.println("Department: "+department);
        System.out.println("name: "+name);
        System.out.println("Salary: "+salary);
        System.out.println("Bonus per month: "+bonus);
    }
}