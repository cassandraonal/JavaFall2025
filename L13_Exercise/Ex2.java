import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Ex2{
    public static void main(String[] args) {
       try {
           Scanner input = new Scanner(System.in);
           FileWriter a = new FileWriter("Roster.txt");
           for(int i=0;i<5;i++){
            System.out.print("Enter name of your friend: ");
            String name = input.next();
            a.write(name+"\n");
           }
           a.close();
       } catch (IOException e){
        System.out.print("Some errors");
       } 
    }
}