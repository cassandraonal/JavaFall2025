class vehicle {
    String brand;
    int price;
    
    vehicle(String b, int p){
        brand = b;
        price = p;
    }
    vehicle(String b){
        brand = b;
        price = 0;
    }
    vehicle(){
        brand = "TBD";
        price = 0; 
    }
    void display(){
        System.out.println(brand+" "+price);
    }
}
