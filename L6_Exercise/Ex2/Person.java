class Person {
    String fname, lname;
    int age;
    void setInfo(String f, String l, int a){
        fname = f;
        lname = l;
        age = a;
    }
    void displayInfo(){
        System.out.println(fname+" "+lname+" "+age);
    }
}
