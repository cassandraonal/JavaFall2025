public class CreditcardPayment extends Payment{
    private String name;
    private int exp;
    private long cardnum;
    CreditcardPayment(double a, String n, int e, long c){
        super(a);
        name = n;
        exp = e;
        cardnum = c;
    }
    CreditcardPayment(){
        this(0,"TBD",0,0);
    }

    void paymentDetails(){
        System.out.println("The Credit card payment amount is "+this.getAmount());
        System.out.println("name: "+name);
        System.out.println("Card number: "+cardnum);
    }
}
