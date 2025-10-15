class testvehicle {
    public static void main(String [] args){
        vehicle v1 = new vehicle("Toyota", 30000);
        vehicle v2 = new vehicle("Tesla",80000);
        vehicle v3 = new vehicle("BMW");
        vehicle v4 = new vehicle();
        v1.display();
        v2.display();
        v3.display();
        v4.display();
    }
}
