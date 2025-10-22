public class Person {
    private String fname;
    private String lname;
    private int age;

    static String country = "US";
    
    String getLname() {
        return lname;
    }

   String getFname(){
        return fname;
    }

    int getAge(){
        return age;
    } 

    void setLname(String l){
        lname = l;
    }

    void setFname(String f){
        fname = f;
    }
    void setAge(int a){
        age = a;
    }
    static void updateCountry(String c ){
        country = c;
    }
    
}
