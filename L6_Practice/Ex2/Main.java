public class Main{
    public static void main(String args[]){
    Money a = new Money(5);
    a.print(); // $5.00
    a.setDollar(2);
    a.setCent(30);
    a.print(); // $2.30
    Money b = new Money(1,130);
    b.print(); // $2.30
    Money c = new Money();
    c.print(); // $0.00
    System.out.println(a); // $2.30
    }
}

