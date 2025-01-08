import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    static ArrayList<String> toDoList = new ArrayList<String>();
    static Scanner scanner = new Scanner(System.in);

    //main code runs here
    public static void main(String[] args) {

        //default tasks to it displays something
        toDoList.add("Tanking Vitamin D"); //go outside pls

        while (true) {
            loadMenu();
            int answerToMenu = scanner.nextInt();
            scanner.nextLine();

            switch (answerToMenu) {
                case 1 -> viewToDoList(false);
                case 2 -> addTask();
                case 3 -> editTask();
                case 4 -> deleteTask();
                case 5 -> clearAllTasks();
                case 6 -> exitProgram();
                default -> System.out.println("Please enter a valid number!");
            }
        }

    }

    public static void loadMenu() {
        System.out.println("+-----------------------------------+\n" +
                "|          To-Do List Menu          |\n" +
                "|          select something         |\n" +
                "+-----------------------------------+\n" +
                "|  1. View To-Do List               |\n" + //completed
                "|  2. Add Task                      |\n" + //completed
                "|  3. Edit Task                     |\n" + //completed
                "|  4. Delete Task                   |\n" +
                "|  5. Clear All Tasks               |\n" +
                "|  6. Exit Application              |\n" +
                "+-----------------------------------+\n");
    }

    public static void viewToDoList(boolean updated) {

        if (updated == true) {
            System.out.println("\nYour updated Tasks: ");
        } else {
            System.out.println("\nYour current Tasks: ");
        }

        for (int i = 0; i < toDoList.size(); i++) {

            if (toDoList.get(i) == toDoList.get(toDoList.size() - 1)) {
                System.out.print(toDoList.get(i) + ".\n");
                break;
            }

            System.out.print(toDoList.get(i) + ", ");
        }
    }

    public static void addTask() {

        System.out.println("How many Tasks would you like to add?");
        int amountOfTasks = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < amountOfTasks; i++) {
            if (i == 0) {
                System.out.println("\nWhat Task do you wanna add?");
            } else {
                System.out.println("\nWhat else do you wanna add?");
            }

            String answer = scanner.nextLine();
            toDoList.add(answer);
        }

        viewToDoList(true);
    }

    public static void editTask() {
        System.out.print("The Tasks: ");

        //displays all the arrays items(tasks)
        for (int i = 0; i < toDoList.size(); i++) {

            if (toDoList.get(i) == toDoList.get(toDoList.size() - 1)) {
                System.out.print(toDoList.get(i) + ".\n");
                break;
            }

            System.out.print(toDoList.get(i) + ", ");
        }

        System.out.println("Which Task do you wanna edit (write as whole number)");
        int editTaskIndex = scanner.nextInt(); //this does not change to the next line imminently
        scanner.nextLine(); //this does the job

        System.out.println("What should the new Task be?");
        String newTask = scanner.nextLine();

        toDoList.set(editTaskIndex - 1, newTask);

        viewToDoList(true);
    }

    public static void deleteTask() {

        viewToDoList(false);
        System.out.println("What task would you like to delete? (write in numbers)");

        int deleteIndex = scanner.nextInt();
        scanner.nextLine();

        toDoList.remove(deleteIndex - 1);

        viewToDoList(true);
    }

    public static void clearAllTasks() {
        toDoList.clear();
    }

    public static void exitProgram() {
        System.exit(0);
    }

}
