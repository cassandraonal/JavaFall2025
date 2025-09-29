public class Ex1{
  public static void main(String[] args) {
    /*
    Create an array with five values
    "Monday","Tuesday","Wednesday","Thursday","Friday"

    print these element one by one
    and update the array to
    "Monday" => "Mon"
    "Tuesday" => "Tue"
    ...
    "Friday" => "Fri"
    */
    String [] a = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
    System.out.println(a[0]);
    System.out.println(a[1]);
    System.out.println(a[2]);
    System.out.println(a[3]);
    System.out.println(a[4]);
    a[0] = "Mon";
    a[1] = "Tue";
    a[2] = "Wed";
    a[3] = "Thu";
    a[4] = "Fri";
    System.out.println(a[0]);
    System.out.println(a[1]);
    System.out.println(a[2]);
    System.out.println(a[3]);
    System.out.println(a[4]);
  }
}