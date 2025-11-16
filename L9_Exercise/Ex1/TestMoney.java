class TestMoney{
    static double total(Money [] m){
        double s = 0;
        for(int i=0;i<m.length;i++){
            if(m[i] instanceof Bill)
                s += ((Bill)m[i]).MoneyAmount();
            else if( m[i] instanceof Coin )
                s += ((Coin)m[i]).MoneyAmount();    
        }
        return s;
    }
    public static void main(String args[]){
        Money a;
        a = new Bill(5);
        a.displayAmount(); // 5 dollar
        a = new Coin(15);
        a.displayAmount(); // 15 cents
        a = new Quarter();
        a.displayAmount(); // 25 cents
        a = new Nickel();
        a.displayAmount(); // 5 cents
        a = new Dime();
        a.displayAmount(); // 10 cents
        a = new Penny();
        a.displayAmount(); // 1 cents
        Money [] b = new Money[6];
        b[0] = new Bill(5);
        b[1] = new Coin(15);
        b[2] = new Penny();
        b[3] = new Quarter();
        b[4] = new Dime();
        b[5] = new Nickel();
        for(int i=0;i<b.length;i++) b[i].displayAmount();
        System.out.println(total(b)); // 5.56
        //System.out.println(b[0].MoneyAmount()); // error
        //System.out.println(((Bill)b[0]).MoneyAmount()); // works
    }
}