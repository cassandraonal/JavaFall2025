class Main{
    public static void main(String args[]){
        Employee e = new Employee(1234,"Jack","IT",78000);
        e.display();
        e = new Clerk(6789,"Sam","Sales",45000);
        e.display();
        e = new Manager(6767,"Tom","Market",98000);
        e.display();
    }
}
