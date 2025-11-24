class Main{
    public static void main(String[] args) {
        MyMath<Integer, Integer> obj1 = new MyMath<Integer, Integer>();
        System.out.println(obj1.add(10,20)); //30
        MyMath<Double, Double> obj2 = new MyMath<Double, Double>();
        System.out.println(obj2.add(1.1,2.2)); // 3.3
        MyMath<String, String> obj3 = new MyMath<String, String>();
        System.out.println(obj3.add("Hello","World")); // "HelloWorld"
        MyMath<Character, Character> obj4 = new MyMath<Character, Character>();
        System.out.println(obj4.add('A','z')); // 187
        MyMath<Double, Integer> obj5 = new MyMath<Double, Integer>();
        System.out.println(obj5.add(1.1,10)); // 11.1
        MyMath<Integer, Double> obj6 = new MyMath<Integer, Double>();
        System.out.println(obj6.add(10,1.4)); // 11
        MyMath<String, Integer> obj7 = new MyMath<String, Integer>();
        System.out.println(obj7.add("Hello",100)); // Hello100
        MyMath<Integer, String> obj8 = new MyMath<Integer, String>();
        System.out.println(obj8.add(100, "Hello")); // 100Hello
    }
}
