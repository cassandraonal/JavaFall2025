public class Exercise1 {
    public static void main(String[] args){
        int i1 = 1;
        while(i1 <= 100){ // comparison
            System.out.println(i1+" ");
            i1++; //update
        }
        System.out.println();
        // print out 100 to 200
        int i2 = 100;
        while(i2 <= 200){
            System.out.println(i2+" ");
            i2++;
        }
        System.out.println();
        // Print all the even number from 1 to 100
        // 2 4 6 8 10 12 ... 98 100
        int i3 = 0;
        while(i3 <= 100){
            if(i3%2==0){
              System.out.println(i3+" ");
            }
            i3++;
        }
        System.out.println();
        //second approach
        int i4 = 2;
        while(i4 <= 100){
              System.out.println(i4+" ");
              i4+=2; // i4 = i4 + 2;
        }
        System.out.println();
        int r = 0;
        int c = 1;
        while(c<=10){
            r = r + c;
            c++;
        }
        System.out.println(r);
        System.out.println();
        int r1 = 0; // result of sum starting at 0.
        int i5 = 1; //counter
        while(i5<=100){ //condition to add up to 100
            r1 = r1 + i5;
            i5++;
        }
        System.out.println(r1);
        System.out.println();
        int r2 = 0; // result of sum starting at 0.
        int i6 = 2; //counter
        while(i6<=100){ //condition to add up to 100
            r2 = r2 + i6;
            i6+=2;
        }
        System.out.println(r2);
        System.out.println();
        //Ex6 : calculate the factorial 10 use while
        //10! = 10 * 9* 8 * 7... * 1 = 3628800
        int r3 = 1; // result of sum starting at 1. for multiplication
        int i7 = 10; //counter
        while(i7>= 1){ //condition
            r3 = r3 * i7;
            i7--; // decreasing for going from 10 down to 1.
        }
        System.out.println(r3);
    }
}

   