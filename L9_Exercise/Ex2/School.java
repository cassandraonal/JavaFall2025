package Ex2;
/*
d, Create a school class.
School class has variable call member[] which is Person type
Add a one arg construtor which is int to setup the size of member
Define add() function which can add new student or teacher to member
Define remove() function which can remove the last added element from member
Define display() function which can display all element in member
*/
class School{
    private Person [] member;
    private int numMember;
    
    School(int size){
        member = new Person[size];
        numMember = 0;
    }
    void add(Person a){
        if(numMember<member.length){
            member[numMember++] = a;
        }
        else{
            System.out.println("No more space for new member.");
        }
    }
    void remove(){
        if(numMember>0){
            member[--numMember] = null;
        }
        else{
            System.out.println("No more member can be removed.");
        }
    }
    void display(){
        if(numMember>0){
            for(int i=0;i<numMember;i++){
                member[i].displayInfo();
            }
        }
        else{
            System.out.println("No more member can be displayed.");
        }
    }
}