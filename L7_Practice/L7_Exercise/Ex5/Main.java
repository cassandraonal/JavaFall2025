public class Main {
    public static void main(String args[]){
    new Calculation().fact(5);//calling method with anonymous object
    new Calculation().fact(10);
    Calculation c1 = new Calculation();
    c1.fact(10);
  }
}
