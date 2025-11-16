/*
One interface eatable -> eat()
Create two class implements eatable
Pig, Dog
Test use following main

public static void main(String args[]){
    eatable d=new Pig();
    d.eat();  // Pig eat a lot
    d = new Dog();
    d.eat();  // Dog eat too much
}
*/
class TestEatable{
    public static void main(String args[]){
        eatable d=new Pig();
        d.eat();  // Pig eat a lot
        d = new Dog();
        d.eat();  // Dog eat too much
    }
}