public class Car extends vehicle{
    private int cylinder;

    Car(String b, int p, int c){
        super(b,p);
        cylinder = c;
    }
    Car(){this("tbd",0,0);}
    void dipslay(){
        super.display();
        System.out.printf("%s, Cylinnder: %s\n",super.toString(),cylinder);
    }
}
