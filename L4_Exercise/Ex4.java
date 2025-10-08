/*
 create a two di array which save
 10 11 12 13 14
 15 16 17 18 19 
 20 21 22 23 24
 25 26 27 28 29
 print 13, 16, 24, and 27
 */
public class Ex4 {
    public static void main(String[] args){
        int [][] a = {{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24},{25,26,27,28,29}};
        System.out.println(a[0][3]);
        System.out.println(a[1][1]);
        System.out.println(a[2][4]);
        System.out.println(a[3][2]);
        /*
         * print everything in this 2d array using for loop
         */
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        /*
         *  time 10 to each element and print it out
         */
         for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]*10 + " ");
            }
            System.out.println();
        }
        /*
         *  only print the evens in the array
         */
         for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]%2==0)
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
  