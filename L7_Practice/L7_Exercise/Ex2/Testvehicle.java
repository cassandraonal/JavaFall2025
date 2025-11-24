class Testvehicle {
    public static void main(String[] args) {
        vehicle s1 = new vehicle();
        vehicle s2 = new vehicle("Honda");
        vehicle s3 = new vehicle("BMW",500000,6);
        vehicle s4 = new vehicle("Tesla",70000);
        s1.display();
        s2.display();
        s3.display();
        s4.display();
    }
}
