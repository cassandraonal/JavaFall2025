package Ex2;
class TestMain{
    public static void main(String [] args){
        School a = new School(4);
        a.add(new Student("Tom",123456));
        a.add(new Teacher("Jay","Math"));
        a.add(new Student("Sam",56788));
        a.add(new Student("Jack",1678222));
        a.display();
        //Student name: Tom id:123456
        //Teacher name: Jay Subject:Math
        //Student name: Sam id:56788
        //Student name: Jack id:1678222
        a.remove();
        a.remove();
        a.add(new Teacher("Kate","Chemistry"));
        a.display();
        //Student name: Tom id:123456
        //Teacher name: Jay Subject:Math
        //Teacher name: Kate Subject:Chemistry 
    }
}