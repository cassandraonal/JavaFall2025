/*
Print the square of a number.
Goal:
Get a number and print the square.
Instruction:
0. Declare a variable n. (Use double type)
1. Get user input of a number and store the value input in the variable n.
2. Calculate the square of n.
3. Show the square of n.
4. Add comments in the code using //.
*/
import java.util.Scanner;
public class Ex3 {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        int s_n = n * n;
        System.out.println("Square of "+n+" is "+s_n);
        System.out.printf("Square of %d is %d\n",n,s_n);
    }
}