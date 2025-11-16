class Employee{
    private int ID;
    private String department;
    private String name;
    private int salary;
    private int bonus = 200;
    Employee(int i, String n, String d, int s){
        ID = i;
        name = n;
        department = d;
        salary = s;
    }
    int getID(){return ID;}
    int getSalary(){return salary;}
    String getName(){return name;}
    String getDepartment(){return department;}
    void display(){
        System.out.println("Employee ID: "+ID);
        System.out.println("Department: "+department);
        System.out.println("name: "+name);
        System.out.println("salary: "+salary);
        System.out.println("Bonus per month: "+bonus);
    }
}