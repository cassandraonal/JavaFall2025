import java.util.Scanner;
public class Ex6{
  public static void main(String[] args) {
    /*
    Exercise 20: A table of triangle number (user supplies height)
    Enter integer: 4
    1 = 1
    1 2 = 3
    1 2 3 = 6
    1 2 3 4 = 10
    */
    Scanner input = new Scanner(System.in);
    System.out.print("Enter row: ");
    int r = input.nextInt();
    for(int i=1;i<=r;i++){
        int sum = 0;
        for(int j=1;j<=i;j++){
            System.out.print(j+" ");
            sum = sum + j;
        }
        System.out.println("= "+sum);
    }
  }
}