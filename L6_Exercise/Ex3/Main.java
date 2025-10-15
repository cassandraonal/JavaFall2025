class Main {
    public static void main(String [] args){
        vehicle v1 = new vehicle("Toyota", 30000);
        vehicle v2 = new vehicle("Tesla",80000);
        vehicle v3 = new vehicle("BMW");
        vehicle v4 = new vehicle();
        v1.display(); // print "Brand: Toyota, Price: 30000"
        v2.display(); // print "Brand: Tesla, Price: 80000"
        v3.display(); // print "Brand: BMW, Price: 0"
        v4.display(); // print "Brand: TBD, Price: 0"
    }
}
