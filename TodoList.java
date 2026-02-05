package Task3;

import java.util.LinkedList;
import java.util.Scanner;

public class TodoList {
    static void main() {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> todolist = new LinkedList<>();


        while (true) {
            System.out.println("\n---- TO-DO LIST MENU ----");
            System.out.println("1. Add new task");
            System.out.println("2. Remove completed task");
            System.out.println("3. Display current to-do list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            System.out.println();


            switch (choice) {
                case 1:
                    System.out.println("Enter the task: ");
                    String task = sc.nextLine();
                    todolist.add(task);
                    System.out.println("Task added");
                    break;
                case 2:
                    if (todolist.isEmpty()) {
                        System.out.println("No pending tasks");
                        break;
                    }
                    System.out.println("Choose the task to remove");
                    int index = sc.nextInt();
                    if (index < 1 || index > todolist.size()) {
                        System.out.println("Invalid Input!");
                    } else {
                        todolist.remove(index - 1);
                        System.out.println("Task removed Successfully");
                    }
                    break;
                case 3:
                    System.out.println("Displaying the list");
                    if (todolist.isEmpty()){
                        System.out.println("No tasks found");
                    }else {
                        System.out.println("pending Tasks");
                        display(todolist);
                    }
                    break;
                case 4:
                    System.out.println("Thanks for using our app");
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid Input");

            }
        }

    }
    static void display (LinkedList<String>list){
        for (int i =0;i<list.size();i++){
            System.out.println(i+1+". "+list.get(i));
        }
    }
}
