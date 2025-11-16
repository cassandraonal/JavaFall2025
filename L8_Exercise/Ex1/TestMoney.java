package Ex1;
public class TestMoney {
     static double total(Money [] m){
         double s = 0;
         for(int i=0; i<m.length;i++){
            if(m[i] instanceof Bill)
                s += ((Bill)m[i]).MoneyAmount();
            else if (m[i] instanceof Coin)
                s += ((Coin)m[i]).MoneyAmount();
         }
         return s;
    }
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

        Money [] b = new Money[6];
        b[0] = new Bill(5);
        b[1] = new Coin(15);
        b[2] = new Penny();
        b[3] = new Quarter();
        b[4] = new Dime();
        b[5] = new Nickel();
        for(int i=0; i<b.length;i++)
            b[i].displayAmount();
        System.out.println(((Bill)b[0]).MoneyAmount());
        System.out.println(total(b));
    }    
}
