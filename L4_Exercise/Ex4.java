public class Ex4{
  public static void main(String[] args) {
    /*
    create a two dim array which save
    10 11 12 13 14
    15 16 17 18 19
    20 21 22 23 24
    25 26 27 28 29
    print 13, 16, 24, and 27
    */
    int [][] a = {{10,11,12,13,14},
    {15,16,17,18,19},{20,21,22,23,24},
    {25,26,27,28,29}};
    System.out.println(a[0][3]);
    System.out.println(a[1][1]);
    System.out.println(a[2][4]);
    System.out.println(a[3][2]);
    /*
    create a two dim array which save
    10 11 12 13 14
    15 16 17 18 19
    20 21 22 23 24
    25 26 27 28 29
    print everything in the 2d array use for loop
    */
    for(int i=0;i<a.length;i++){
      for(int j=0;j<a[i].length;j++){
        System.out.print(a[i][j]+" ");
      }
      System.out.println();
    }
    /*
    2. times 10 to each element and print out
    100 110 120 130 140
    150 160 170 180 190
    200 210 220 230 240
    250 260 270 280 290
    */
    for(int i=0;i<a.length;i++){
      for(int j=0;j<a[i].length;j++){
        System.out.print(a[i][j]*10+" ");
      }
      System.out.println();
    }
    /*
    3. print only even numbers of the Arrays
    10 12 14
    16 18
    20 22 24
    26 28
    */
    for(int i=0;i<a.length;i++){
      for(int j=0;j<a[i].length;j++){
        if(a[i][j]%2 == 0)  
          System.out.print(a[i][j]+" ");
      }
      System.out.println();
    }
  }
}