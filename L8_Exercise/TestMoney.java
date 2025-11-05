public class TestMoney {
    public static void main(String args[]){
        Money a;
        a = new Bill(5);
        a.displayAmount(); //Bill 5
        a = new Coin(15);
        a.displayAmount(); // 15 cents
        a = new Penny();
        a.displayAmount();
        a = new Quarter();
        a.displayAmount();
        a = new Nickel();
        a.displayAmount();
        a = new Dime();
        a.displayAmount();

        Money [] b = new Money[5];
        b[0] = new Bill(5);
        b[1] = new Coin(15);
        b[2] = new Penny();
        b[3] = new Quarter();
        b[4] = new Dime();
        b[5] = new Nickel();
        for(int i=0; i<b.length;i++)
            b[i].displayAmount();
    }    
}
