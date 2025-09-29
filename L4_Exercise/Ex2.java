public class Ex2{
  public static void main(String[] args) {
    /*
    Create an array with five values
    "Monday","Tuesday","Wednesday","Thursday","Friday"
    print these element use for loop
    */
    String [] a = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
    for(int i=0;i<a.length;i++)
        System.out.println(a[i]);
    /* Create an array with 1-100, print everything out use for loop*/
    int [] b = new int[100];
    for(int i=0;i<b.length;i++){
        b[i] = i+1;
    }
    for(int i=0;i<b.length;i++)
        System.out.print(b[i]+" ");
    System.out.println();
    /*
    Create an array with five values
    "Monday","Tuesday","Wednesday","Thursday","Friday"
    print these element use for-each loop
    */
    String [] c = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
    for(String i: c){
        System.out.println(i);
    }
  }
}