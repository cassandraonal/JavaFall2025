class TestWallet{
    public static void main(String [] args){
        //Wallet a = new Wallet(5);
        Wallet a = new Wallet();
        a.add(new Coin(15));
        a.add(new Bill(15));
        a.add(new Nickel());
        a.add(new Dime());
        a.add(new Quarter());
        System.out.println("$"+a.total()); // 15.55
        a.display();
        //15 cents, 15 dollar, 5 cents, 10 cents, 25 cents
        a.spend();
        System.out.println("$"+a.total()); // 15.30
        a.display();
        //15 cents, 15 dollar, 5 cents, 10 cents,
        a.spend();
        System.out.println("$"+a.total()); // 15.20
        a.display();
        //15 cents, 15 dollar, 5 cents,
    }
}