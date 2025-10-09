/*
Exercise 8: Write a function called circle_Area() that takes an
double value from parameter, calculates the area of the circle,
returns the area of the circle (pi=3.14, circle area = pi * r^2)

*/
public class Ex7{
    public static double circle_area(double r){
        double pi = 3.14;
        double area = pi * r * r;
        return area;
    }
    public static void main(String[] args) {
        System.out.println(circle_area(1)); // 3.1416
        System.out.println(circle_area(10)); // 314.16
        System.out.println(circle_area(100)); // 31416
    }
}