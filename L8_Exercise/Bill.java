public class Bill extends Money{
    private int dollar;
    Bill(int d){dollar = d;}
    void displayAmount(){
         System.out.println("Bill "+dollar);
    }
    double MoneyAmount(){
         return dollar;
    }


}
