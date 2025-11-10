public class Main {
    public static void main(String args[]){
    Employee [] e = new Employee[3];
    e[0]= new Employee(1234,"Jack","IT",78000,10);
    e[1] = new Clerk(6789,"Sam","Sales",45000,5);
    e[2] = new Manager(6767,"Tom","Market",98000,2);
        for(int i=0;i<e.length;i++){
        e[i].display();
        }
    }
}
