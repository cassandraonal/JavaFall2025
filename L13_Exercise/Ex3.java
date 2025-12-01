import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex3{
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            File a = new File("Roster.txt");
            while(a.hasNextLine()){
                String name = a.nextLine();
                System.out.println("Hello "+name);
            }
            a.close();
            }catch (IOException e) {
            System.out.print("Some errors");
        }
    }
}