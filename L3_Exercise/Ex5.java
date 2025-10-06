import java.util.Scanner;
public class Ex5 {
    public static void main(String[] args) {
    /*
    Exercise 16: Ask user input an integer, and print the number as following.
    Enter integer: 4
    1 2 3 4
    1 2 3
    1 2
    1
    */
    Scanner input = new Scanner(System.in);
    System.out.print("Enter row: ");
    int r = input.nextInt();
    for(int i=1;i<=r;i++){
        for(int j=1;j<=r-i+1;j++){
            System.out.print(j+" ");
        }
        System.out.println();
    }
  }
}
