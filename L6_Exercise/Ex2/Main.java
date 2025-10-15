class Main{
    public static void main(String args[]){
        Person p1=new Person();
        Person p2=new Person();
        p1.setInfo("David","Brown",20);
        p2.setInfo("John","Dow",30);
        p1.displayInfo(); // David Brown 20
        p2.displayInfo(); // John Dow 30
    }
}