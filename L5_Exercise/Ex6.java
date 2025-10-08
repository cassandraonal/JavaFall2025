public class Ex6{
    public static int multiply(int a, int b){
        return a * b;
    }
    public static double multiply(double a, double b){
        return a * b;
    }
    public static void main(String[] args){
        System.out.println(multiply(1.5,2.5));
        System.out.println(multiply(4,5));
        System.out.println(multiply(10,20));
        System.out.println(multiply(1.5,10)); // uses double because of overloading
        System.out.println(multiply(10,1.5)); // " "
    }
}