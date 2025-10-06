import java.util.Scanner;
public class Ex3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Exercise 1: Print 1 to 100 use for
        for(int i=1;i<=100;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        //Exercis 2: Print 100 to 200 use for
        for(int i=100; i<=200;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        //Exercise 3: print all the even number from 1 to 100
        //2,4,6,8,10...100
        //first approach
        for(int i=2;i<=100;i+=2){
            System.out.println(i+" ");
        }
        System.out.println();
        //second approach
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        //Exercise 4: calculate sum of 1 to 100 use for
        //1 +2 + 3+ 4...+100 = 5050
        int r1 = 0;
        for(int i=1;i<=100;i++){
           r1 = r1 + i;
        }
        System.out.println(r1);
        //Exercise 5: calculate sum of even number from 1 to 100
        //2 + 4 + 6 + 8...+ 100 = 2550
        int r2 = 0;
        for(int i=2;i<=100;i+=2){
            r2 = r2 + i;
        }
        System.out.println(r2);
        //Exercise 6: calculate the factorial 10 use for
        //10! = 10 * 9 * 8 * 7 ... * 1 = 3628800
        int r3 = 1;
        for(int i=10;i>=1;i--){ // starts at 10 counts down to 1, so i=10; i>=1; i--
            r3 = r3 * i;
        }
        System.out.print(r3);
    }
}
