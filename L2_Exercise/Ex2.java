import java.util.Scanner;
public class Ex2 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        if(age > 18 && age < 75)
            System.out.println("You can drive");
        else if(age < 0)
            System.out.println("You are idiot");
        else if (age >= 0 && age <= 18)
            System.out.println("You are not eleigible to drive");
        else
            System.out.println("Do not drive for your safety");
    }

}