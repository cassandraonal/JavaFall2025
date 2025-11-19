import java.util.ArrayList;
public class Ex4{
    public static void main(String[] args){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for(int i=1; i<=100;i++) number.add(i);
        System.out.println(number);
        number.removeIf(integer -> integer%2==0);
        System.out.println(number);
    }
}