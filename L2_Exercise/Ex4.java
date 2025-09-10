import java.util.Scanner;
public class Ex4 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you wish to go to the movies(1/0)?");
        int m = input.nextInt();
        System.out.println("Do you wish to go to Dinner(1/0)?");
        int d = input.nextInt();
        if (m == 1 && d == 0) System.out.println("You are going to the movies");
        else if(m==0 && d == 1) System.out.println("You are going to Dinner");
        else if(m==0 && d == 0) System.out.println("You must do something");
        else if(m==1 && d==1) System.out.println("You cannot do both");
        else System.out.println("You entered an invalid option");
        
    }
}
