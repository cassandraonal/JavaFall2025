package Ex1;
class Main {
    public static void main(String [] args){
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        e1.name = "Jack";
        e1.id = 123456;
        e2.name = "David";
        e2.id = 888888;
        System.out.println(e1.name +" "+e1.id);
        System.out.println(e2.name +" "+e2.id);
    }
    
}
