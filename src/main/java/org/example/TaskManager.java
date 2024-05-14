package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
    private List<Tasks> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name, String description, String status, LocalDate dueDate, String priority, String category, int id) {
        Tasks newTask = new Tasks(name, description, status, dueDate, priority, category, id);
        tasks.add(newTask);
    }

    public List<Tasks> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public void updateStatus(int id, String status) {
        for (Tasks task : tasks) {
            if (task.getId() == id) {
                task.setStatus(status);
                if (status.equals("Completed" + "Done")) {
                    System.out.println("Task completed successfully!");
                    System.out.println("Task completed on: " + task.getDueDate());
                    System.out.println();
                    break;
                }
                break;
            }
        }
    }

    public void deleteTask(int id) {
        Iterator<Tasks> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Tasks task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void saveTasksToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Tasks task : tasks) {
                writer.write("Name: " + task.getName() + "\n");
                writer.write("Description: " + task.getDescription() + "\n");
                writer.write("Status: " + task.getStatus() + "\n");
                writer.write("Due Date: " + task.getDueDate().format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");
                writer.write("Priority: " + task.getPriority() + "\n");
                writer.write("Category: " + task.getCategory() + "\n");
                writer.write("ID: " + task.getId() + "\n");
                writer.write("\n"); // Separate tasks with a blank line
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
