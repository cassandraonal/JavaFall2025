package Ex1;
public class Coin extends Money{
    private double cent;
    Coin(double c){cent = c;}
    void displayAmount(){
         System.out.println(cent+" cents");
    }
    double MoneyAmount(){
         return cent/100.0;
    }
}