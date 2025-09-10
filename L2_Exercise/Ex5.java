import java.util.Scanner;
public class Ex5 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Is it raining? (true/false)?");
        Boolean r = input.nextBoolean();
        if(r){
            System.out.println("Do you want to,\n1) Watch Tv\n2) Do homework");
            int option = input.nextInt();
            if(option == 1) System.out.println("You chose to watch TV");
            else if(option == 2) System.out.println("You chose to do homework");
            else System.out.println("You entere an invalid option");
        }
        else{
            System.out.print("Do you want (1) Hit the beach (2) Attend a museum opening?");
            int option = input.nextInt();
            if(option == 1) System.out.println("You chose to go to the beach");
            else if(option == 2) System.out.println("You chose to attend a museum opening");
            else System.out.print("You entered an invalid option");

        }

    }
}