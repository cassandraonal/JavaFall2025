//Creating a test class to deposit and withdraw amount
class TestAccount{
    public static void main(String[] args){
        Account a1=new Account();
        a1.insert(832345,"Jack",1000);
        a1.display();
        //System.out.println(a1.acc_no);
        System.out.println(a1.name);
        System.out.println(a1.amount);
        //a1.acc_no = 123456;
        a1.name = "David";
        a1.amount = 1000000;
        System.out.println(a1.name);
        System.out.println(a1.amount);

        //System.exit(1);
        //a1.checkBalance();
        a1.deposit(40000);
        a1.display();
        a1.withdraw(15000);
        a1.display();
    }
}
/*
Course class: name, id, gpa, midtem and final exam
all the member variable have be private
create a constructor function initilize the Course
initilize name, id, midterm, and final
Create a function display information of Course
Calculate GPA function which will use midterm and final
to calculte gpa, mid - 40%, final - 60%
if overall grade is
>90 A
>80 B
>70 C
<70 F

public static void main(String[] args){
  Course c1 = new Course("Jack",12345,80,90);
  c1.display();
  // name: Jack, ID: 12345, Midterm: 80, Final: 90, GPA: B
  // overall: 80 * 0.4 + 90 * 0.6 = 86 => B
}
*/
