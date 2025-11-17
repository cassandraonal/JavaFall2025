import java.util.ArrayList;
public class Ex3{
    public static void main(String[] args){
        ArrayList<String> months = new ArrayList<String>();
        months.add("Jan");
        months.add("Feb");
        months.add("Mar");
        months.add("Apr");
        months.add("May");
        months.add("Jun");
        for(int i = 0; i < months.size(); i++){
            System.out.print(months.get(i)+ " ");
        }
        System.out.println();
        months.set(5, "June");
        months.set(3, "April");
        for(String i: months){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}