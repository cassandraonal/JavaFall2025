class Manager extends Employee{
    private int bonus = 300;
    Manager(int i, String n, String d, int s, int l){
        super(i,n,d,s,l);
    }
    double calculate_leave(){
        double total = getSalary()/240.0 * getLeave() + bonus/20.0 * getLeave();
        return total;
    }
    void display(){
        System.out.println("Manager ID: "+getID());
        System.out.println("Department: "+getDepartment());
        System.out.println("name: "+getName());
        System.out.println("salary: "+getSalary());
        System.out.println("Bonus per month: "+bonus);
        System.out.println("leave deduction: "+calculate_leave());
    }
}