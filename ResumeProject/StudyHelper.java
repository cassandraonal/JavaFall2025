import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    private String name;
    private int priority;     // 1–5 (5 = most important)
    private int daysLeft;     // Deadline in days from today

    public Task(String name, int priority, int daysLeft) {
        this.name = name;
        this.priority = priority;
        this.daysLeft = daysLeft;
    }

    public String getName() { return name; }
    public int getPriority() { return priority; }
    public int getDaysLeft() { return daysLeft; }

    @Override
    public String toString() {
        return name + " | Priority: " + priority + " | Deadline: " + daysLeft + " days";
    }
}

public class StudyHelper {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        System.out.println("=== STUDY HELPER ===");

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Recommended Study Order");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();  // consume newline

            if (choice == 1) {
                System.out.print("Enter task name: ");
                String name = input.nextLine();

                System.out.print("Enter priority (1–5): ");
                int priority = input.nextInt();

                System.out.print("Enter days left until deadline: ");
                int daysLeft = input.nextInt();

                tasks.add(new Task(name, priority, daysLeft));
                System.out.println("Task added!");

            } else if (choice == 2) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks added yet.");
                    continue;
                }

                // Simple scheduling: higher priority & closer deadline = higher rank
                Collections.sort(tasks, new Comparator<Task>() {
                    @Override
                    public int compare(Task a, Task b) {
                        int scoreA = (a.getPriority() * 2) + (10 - a.getDaysLeft());
                        int scoreB = (b.getPriority() * 2) + (10 - b.getDaysLeft());
                        return scoreB - scoreA;  // higher score first
                    }
                });

                System.out.println("\n=== Recommended Study Order ===");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }

            } else if (choice == 3) {
                System.out.println("Exiting Study Helper. Good luck!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        input.close();
    }
}