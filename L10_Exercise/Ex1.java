import java.util.ArrayList;
public class Ex1{
    public static void main(String[] args){
        ArrayList<String> name = new ArrayList<String>();
        name.add("Cassandra");
        name.add("Grace");
        name.add("Onal");
        System.out.print(name.get(0)+" ");
        System.out.print(name.get(1)+" ");
        System.out.println(name.get(2));
    }
}