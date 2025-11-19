import java.util.HashMap;
public class Ex6 {
    public static void main(String[] args) {
        HashMap<String, String> m = new HashMap<String, String>();
        m.put("American Dad", "Stan");
        m.put("It's Always Sunny", "Frank");
        m.put("Dragon Tales", "Cassie");

        for(String movie: m.keySet()){
            System.out.println(m.get(movie) + " is main charactor of "+movie);
        }    
    }
}