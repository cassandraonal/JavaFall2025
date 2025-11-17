import java.util.ArrayList;
public class Ex2{
    public static void main(String[] args) {
        ArrayList<String> fruit = new ArrayList<String>();
        fruit.add("apple");
        fruit.add("banana");
        fruit.add("kiwi");
        System.out.println(fruit);
        fruit.set(2, "pear");
        System.out.print(fruit);
        fruit.remove(1);
        System.out.println(fruit);
        ArrayList<String> fruit2 = new ArrayList<String>();
        fruit2.add("Orange");
        fruit2.add("Strawberry");
        fruit.addAll(fruit2);
        System.out.println(fruit);
        fruit.removeIf(str -> str.contains("r"));
        System.out.println(fruit);
        fruit.clear();
        System.out.println(fruit);

    }
}
