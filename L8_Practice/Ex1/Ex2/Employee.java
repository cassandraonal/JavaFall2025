public class Employee {
    private int employeeid;
    private String name;
    private  String department;
    private int salary;
    private int bonus = 200;
    private int leave;
    Employee(int empid, String n, String d, int s, int l){
        employeeid = empid;
        name = n;
        department = d;
        salary = s;
        leave = l;
    }
    Employee(){this(0,"uknown","none", 0,0);}
    int getemployeeid(){return employeeid;}
    int getSalary(){return salary;}
    String getName(){return name;}
    String getDepartment(){return department;} 
    double calculate_leave(){
        double total = salary/240.0 * leave + bonus/20.0 * leave;
        return total;
    } 
   
  
    void display(){
        System.out.println("Employee id: "+employeeid);
        System.out.println("Department: "+department);
        System.out.println("name: "+name);
        System.out.println("Salary: "+salary);
        System.out.println("Bonus per month: "+bonus);
        System.out.println("leave deduction: "+calculate_leave());
    }
}