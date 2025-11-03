public class Payment {
    private double amount;
    Payment(double a){amount = a;}
    Payment(){this(0);}
    void setAmount(double a){amount = a;}
    double getAmount(){return amount;}
    void paymentDetails(){
        System.out.println("The payment amount is "+amount);
    }
}
