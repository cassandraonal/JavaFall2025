public class Ex5 {
    static double rectangle_area(double width, double height){
        return width * height;
    }
    public static void main(String[] args) {
        System.out.println(rectangle_area(1,2));
        System.out.println(rectangle_area(1.5,2));
        System.out.println(rectangle_area(10,0.5));
    }
}
