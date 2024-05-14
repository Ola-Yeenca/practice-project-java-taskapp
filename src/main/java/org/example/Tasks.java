package org.example;

import java.time.LocalDate;

public class Tasks {
    private final String name;
    private final String description;
    private String status;
    private final LocalDate dueDate;
    private final String priority;
    private final String category;
    private final int id;

    public Tasks(String name, String description, String status, LocalDate dueDate, String priority, String category, int id) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getId() {
        return id;
    }

    // Setter for status (example of modifying mutable property)
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + "\nName: " + name + "\nDescription: " + description + "\nStatus: " + status +
                "\nDue Date: " + dueDate + "\nPriority: " + priority + "\nCategory: " + category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }
}
