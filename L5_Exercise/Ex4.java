public class Ex4 {
    static double absolute(double n){
        if(n<0) return -n;
        else return n;
    }
    public static void main(String[] args) {
        System.out.println(absolute(5.5));
        System.out.println(absolute(-10));
        System.out.println(absolute(0));
    }
}
