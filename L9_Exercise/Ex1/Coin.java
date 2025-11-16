class Coin extends Money{
    private int cent;
    Coin(int c){cent = c;}
    void displayAmount(){
        System.out.println(cent+" cents");
    }
    double MoneyAmount(){
        return cent/100.0;
    }
}