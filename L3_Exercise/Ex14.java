import java.util.Scanner;
public class Ex14 {
    public static void main(String[] args){
        /*
         * 
         * Exercise 14: Ask user input an integer, and print the number as following.
        Enter integer: 4
        1
        1 2
        1 2 3
        1 2 3 4
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter row: ");
        int r = input.nextInt();
        for(int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
//Ex 16: 
/*
 * 
 * Exercise 16: Ask user input an integer, and print the number as following.
Enter integer: 4
1 2 3 4
1 2 3
1 2
1
 */
        System.out.print("Enter a row: ");
        int r1 = input.nextInt();
        for(int i= 1; i<=r1; i++){
            for(int j=1; j<=r1-i+1; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        /*
         * Exercise 20: A table of triangle number (user supplies height)
        Enter integer: 4
        1 = 1
        1 2 = 3
        1 2 3 = 6
        1 2 3 4 = 10
         */
        System.out.println("Enter integer: ");
        int n = input.nextInt();
        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
                sum = sum + j;
            }
            System.out.println("= "+sum);
        }
    }
}
