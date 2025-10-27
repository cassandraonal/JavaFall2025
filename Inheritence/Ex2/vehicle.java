public class vehicle {
    private String brand;
    private int price;
    
    vehicle(String b, int p){
        brand = b;
        price = p;
    }

    vehicle(){
        this("tbd", 0);
    }
    void display(){
        System.out.printf("Brand:%s, Price:%d\n", brand, price);
    }
    public String toString(){
        return String.format("Brand:%s, Price:%d\n", brand, price);
    }
}
