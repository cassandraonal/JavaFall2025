class Clerk extends Employee{
    private int bonus = 100;
    Clerk(int i, String n, String d, int s){
        super(i,n,d,s);
    }
    void display(){
        System.out.println("Clerk ID: "+getID());
        System.out.println("Department: "+getDepartment());
        System.out.println("name: "+getName());
        System.out.println("salary: "+getSalary());
        System.out.println("Bonus per month: "+bonus);
    }
}
