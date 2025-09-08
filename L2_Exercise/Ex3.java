import java.util.Scanner;
public class Ex3 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print(" 'c' for Cheeseburger\n'b' for beef burger\n'f' for french fry\n'w' for water");
        System.out.print("Enter your choice: ");
        char option = input.next().charAt(0);
        switch(option){
            case 'c':
                System.out.println("You chose the cheeseburger");
                break;
            case 'b':
                System.out.println("You chose the beef burger");
                break;
            case 'f':
                System.out.println("You chose french fries");
                break;
            case 'w':
                System.out.println("You chose water");
                break;
            default:
                System.out.println("Invalid option");

        }
    }
}
