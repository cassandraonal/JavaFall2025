public class TestPrimeNumber {
    public static void main(String args[]){
    PrimeNumber a = new PrimeNumber();
    System.out.println(a.getPrimeNumber()); // 1
    System.out.println(a.next()); // 2
    PrimeNumber b = new PrimeNumber(11);
    System.out.println(b.next()); // 13
    System.out.println(b.previous()); // 7
    }
}
