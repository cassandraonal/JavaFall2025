class TestCar{
    public static void main(String args[]){
        vehicle v1=new vehicle();
        v1.display(); // brand: tbd, price: 0
        vehicle v2=new vehicle("BMW",60000);
        v2.display(); // brand: BMW, price: 60000
        Car c1=new Car();
        c1.display(); // brand: tbd, price: 0, cylinder: 0
        Car c2=new Car("Honda",35000,4);
        c2.display(); // brand: Honda, price: 35000, cylinder: 4
    }
}