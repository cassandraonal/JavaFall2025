/*
Exercise 24: Write a program that initializes array
with 3,4,5,2,3. Write a function call minArray which
accepts 1D array, and return the minimum of the
array.
• Exercise 25: Write a program that initializes array
with 3,4,5,2,3. Write a function call avgArray which
accepts 1D array, and return the average of the
array.
*/
public class Ex8{
    public static int min_array(int [] a){
        int minimum = a[0];
        for(int i=0;i<a.length;i++){
            if(minimum>a[i])    
                minimum = a[i];
        }
        return minimum;
    }
    public static double avg_array(int [] a){
        double total = 0.0;
        for(int i=0;i<a.length;i++){
            total += a[i];
        }
        return total / a.length;
    }
    public static void main(String[] args) {
        int [] a = {3,4,5,2,3};
        System.out.println(min_array(a)); // 2
        System.out.println(avg_array(a)); // 
    }
}