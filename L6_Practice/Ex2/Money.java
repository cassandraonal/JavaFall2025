public class Money {
    private int dollar;
    private int cent;
    Money(){
        this(0,0);
    }
    Money(int dollar){
        this(dollar,0);
    }
    Money(int dollar, int cent){
        this.dollar = dollar + cent/100;
        this.cent = cent%100;
        
    }
    void setCent(int cent){
        this.dollar += cent/100;
        this.cent = cent%100;
    }
    void setDollar(int dollar){
        this.dollar = dollar;
    }
    int getCent(){return cent;}
    int getDollar(){return dollar;}
    void print(){
        //System.out.println("$"+(dollar+cent/100.0));
        System.out.printf("$%.2f\n",dollar+cent/100.0);
    }
    public String toString(){
        return String.format("$%.2f\n",dollar+cent/100.0);
    }
}
