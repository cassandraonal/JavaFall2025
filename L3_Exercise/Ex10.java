import java.util.Scanner;
public class Ex10 {
     public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a first number: ");
        int n1 = input.nextInt();
        System.out.println("Enter second number: ");
        int n2 = input.nextInt();
        int i = n1;
        while(i <= n2){
            System.out.println(i+" ");
            i++;
        }
        System.out.println();   
     }
}
