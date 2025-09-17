public class Exercise1 {
  public static void main(String[] args) {
    // while loop
    int i = 0; // initializeation
    while (i < 5) { // comparison
      System.out.println(i);
      i++; // update: self increment (i++ <=> i += 1)
    }
    // Exercise 1: Print 1 to 100 use while
    // initialization
    int i1 = 1;
    while(i1 <= 100){ // comparison
      System.out.print(i1+" ");
      i1++; // update
    }
    System.out.println();
    // Exercise 2: Print 100 to 200 use while
    int i2 = 100;
    while(i2<=200){
      System.out.print(i2+" ");
      i2++; // update
    }
    System.out.println();
    // Exercise 3: Print all the even number from 1 to 100 
    // 2 4 6 8 10 12 ... 98 100
    int i3 = 1;
    while(i3 <= 100){ // comparison
      if(i3%2==0){
        System.out.print(i3+" ");
      }
      i3++; // update
    }
    System.out.println();
    // second approach
    int i4 = 2;
    while(i4<=100){
      System.out.print(i4+" ");
      i4+=2; // i4 = i4 + 2;
    }
    System.out.println();
    // Exercise 4: calculate sum of 1 to 100 use while
    // 1+2+3+4..+100 = 5050
    int r1 = 0;
    int i5 = 1;
    while(i5<=100){
      r1 = r1 + i5;
      i5++;
    }
    System.out.println(r1);
    // Exercise 5: calculate sum of even number from 1 to 100
    // 2 + 4 + 6 + 8 + .... + 100 = 2550
    int r2 = 0;
    int i6 = 2;
    while(i6<=100){
      r2 = r2 + i6;
      i6 = i6 + 2;
    }
    System.out.println(r2);
    // Exercise 6: calculate the factorial 10 use while
    // 10! = 10 * 9 * 8 * 7 .... * 1 = 3628800
    int r3=1;
    int i7 = 10;
    while(i7>=1){
      r3 = r3 * i7;
      i7--;
    }
    System.out.println(r3);
  }
}