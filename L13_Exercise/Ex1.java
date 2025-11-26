import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class Ex1{
    public static void main(String[] args){
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter filename: ");
            String filename = input.next();
            File a = new File(filename);
            if(a.createNewFile()){
                System.out.println("File created: "+ a.getName());
            } else{
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.print("Some errors");
        }
    }
}