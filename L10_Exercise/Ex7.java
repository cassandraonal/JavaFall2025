import java.util.ArrayList;
import java.util.HashSet;
//import java.util*;
public class Ex7 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0; i<11; i++){
            a.add(1+(int)(Math.random()*10));
        }
        System.out.println(a);
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i=0;i<a.size();i++){
            s.add(a.get(i));
        }
        System.out.println(s.size());

    }
}
