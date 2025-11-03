public class CashPayment extends Payment{
    CashPayment(double a){super(a);}
    CashPayment(){this(0);}
    void paymentDetails(){
        System.out.println("The payment amount is "+this.getAmount()+" in cash.");
    }
}
