import java.util.Scanner;
public class Ex4 {
     public static void main(String[] args) {
        for(int i = 1; i <=100; i++){
            System.out.print(i+" ");
        }
        System.out.println();
        // Ex 2: print 100 to 200
        for(int i = 100; i <=200; i++){
            System.out.print(i+" ");
        }
        System.out.println();
        //Ex 3: Print all the even number from 1 to 100
        for(int i = 2; i<=100; i+=2){
            System.out.print(i+" ");
        }

    /*
    Exercise 14: Ask user input an integer, and print the number as following.
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
  }
}

