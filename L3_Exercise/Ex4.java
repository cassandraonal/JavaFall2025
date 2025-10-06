import java.util.Scanner;
public class Ex4 {
    public static void main(String[] args){
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

