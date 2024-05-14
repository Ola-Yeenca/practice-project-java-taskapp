package org.example;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuOptions {
    static TaskManager taskManager = new TaskManager();
    private static final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Menu Options: ");
        System.out.println("1. View all Tasks");
        System.out.println("2. Add a Task");
        System.out.println("3. Delete a Task");
        System.out.println("4. Update a Task");
        System.out.println("5. Exit");
        System.out.println("Choose an option: ");
    }

    public void handleMenuOption(int option) {
        switch (option) {
            case 1:
                System.out.println("View all Tasks");
                displayAllTasks();
                break;
            case 2:
                System.out.println("Add a Task");
                addTask();
                break;
            case 3:
                System.out.println("Delete a Task");
                deleteTask();
                break;
            case 4:
                System.out.println("Update a Task");
                updateTask();
                break;
            case 5:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option, Please try again");
        }
    }

    private void displayAllTasks() {
        List<Tasks> tasks = taskManager.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("*******************************");
            System.out.println("No tasks to display");
            System.out.println("*******************************");
            System.out.println();
        } else {
            System.out.println("*******************************");
            System.out.println("All Tasks: ");
            System.out.println("*******************************");
            for (Tasks task : taskManager.getAllTasks()) {
                System.out.println(task);
                if (task.getStatus().equals("Completed")) {
                    System.out.println("Task completed on: " + task.getDueDate());
                    System.out.println();
                }
            }
            System.out.println("*******************************");
            System.out.println();
        }
    }

    private void addTask() {
        System.out.println("Enter task details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();
        System.out.print("Due Date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Priority: ");
        String priority = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();

        taskManager.addTask(name, description, status, dueDate, priority, category, id);
        System.out.println("Task added successfully!");
    }

    private void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        taskManager.deleteTask(id);
        System.out.println("Task deleted successfully!");
    }

    private void updateTask() {
        System.out.print("Enter task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new status: ");
        String newStatus = scanner.nextLine();
        taskManager.updateStatus(id, newStatus);
        System.out.println("Task status updated successfully!");
    }
}
