import java.util.Scanner;
public class Ex2Whileloop{
  public static void main(String[] args) {
    /*
    Exercise 10: Write a program to print all the
    numbers from n1 to n2, where n1 and n2 are two
    numbers specified by the user. n1 should less than
    n2 (Hint: You’ll need to prompt for two values n1
    and n2; then initialize i to n1 and use n2 in the loop
    condition.)
    Output Example (input in bold):
    Enter a first number: 10
    Enter a second number: 20
    10 11 12 13 14 15 16 17 18 19 20
    */
    Scanner input = new Scanner(System.in);
    System.out.print("Enter first number: ");
    int n1 = input.nextInt();
    System.out.print("Enter second number: ");
    int n2 = input.nextInt();
    int i = n1;
    while (i <= n2){
        System.out.print(i+" ");
        i++;
    }
    System.out.println();
  }
}