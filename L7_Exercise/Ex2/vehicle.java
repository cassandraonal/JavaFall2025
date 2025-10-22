class vehicle{
    String brand;
    double price;
    int numcylinder;

    vehicle(String b, double price, int numcylinder){
        brand = b;
        this.price = price;
        this.numcylinder = numcylinder;
    }
    vehicle(String brand, double price){
        this(brand,price,0);
    }
    vehicle(String brand){
        this(brand,0,0);
    }
    //default constructor
    vehicle(){
        this("TBD",0,0);
    }
    //display
    void display(){
        System.out.println("Brand: "+brand+" ");
        System.out.println("Price: "+price+" ");
        System.out.print("Cylinder "+numcylinder+" ");
    }


}
