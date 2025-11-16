/*
first interface eatable -> eat() -> "name eat a lot"
second interface runable -> run() -> "name run"
third interface flyable -> fly() -> "name fly"
Create three class implements
Pig, Dog, Eagle
pig -> eat, run
Dog -> eat, run
Eagle -> eat, fly
Test use following main

public static void main(String args[]){
   Pig p = new Pig();
   p.eat();
   p.run();
   Dog d = new Dog();
   d.eat();
   d.run();
   Eagle e = new Eagle();
   e.eat();
   e.fly();
}
*/

class TestInterface{
    public static void main(String args[]){
        Pig p = new Pig();
        p.eat();
        p.run();
        Dog d = new Dog();
        d.eat();
        d.run();
        Eagle e = new Eagle();
        e.eat();
        e.fly();
    }
}