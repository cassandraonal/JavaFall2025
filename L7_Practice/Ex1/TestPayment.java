public class TestPayment {
    public static void main(String args[]){
    Payment a = new Payment(10.95);
    a.paymentDetails();
    CashPayment b = new CashPayment(20.95);
    b.paymentDetails();
    CreditcardPayment c = new
    CreditcardPayment(30.95,"abc",12345678,1212);
    c.paymentDetails();
}
}
