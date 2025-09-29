import java.util.Scanner;
public class Ex3{
  public static void main(String[] args) {
    /*
    Write a program that prompts the user for
    each of eight values stores these in an array.
    1. Prints each of these out.
    2. Prints their total.
    */
    int [] a = new int[8];
    Scanner input = new Scanner(System.in);
    for(int i=0;i<a.length;i++){
        System.out.print("Enter index "+i+": ");
        a[i] = input.nextInt();
    }
    int sum = 0;
    for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
        sum = sum + a[i];
    }
    System.out.println("\nSum: "+sum);
  }
}