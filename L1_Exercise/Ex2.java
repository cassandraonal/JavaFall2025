/*
Exercise:
Create a program that ask user's name and age.
print out "your name is xxx, and you are xxx years old"

example:
Enter your name: David
Enter your age: 19
Your name is David, and you are 19 years old
*/
import java.util.Scanner;
public class Ex2 {
    public static void main(String [] args){
        Scanner a = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = a.next();
        System.out.print("Enter your age: ");
        int age = a.nextInt();
        System.out.println("Your name is "
        + name + ", and you are " + age + " years old ");
    }
}