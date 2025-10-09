import java.util.Scanner;
public class Ex5{
  public static void main(String[] args) {
    /*
    create a two dim array which save
    use for loop to initialize the array to 
    10 11 12 13 14
    15 16 17 18 19
    20 21 22 23 24
    25 26 27 28 29
    Find out the average of this array
    */
    int [][] a = new int[4][5];
    int counter = 10;
    int sum = 0;
    for(int i=0;i<a.length;i++){
        for(int j=0;j<a[i].length;j++){
            a[i][j] = counter++;
            sum += a[i][j];
        }
    }
    for(int i=0;i<a.length;i++){
      for(int j=0;j<a[i].length;j++){
        System.out.print(a[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println("Average is "+ (sum*1.0/(a.length*a[0].length)));
    
  }
}