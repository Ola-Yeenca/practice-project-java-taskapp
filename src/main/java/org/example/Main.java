package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Task Manager!");
        System.out.println("***********************");

        Scanner scanner = new Scanner(System.in);
        MenuOptions menu = new MenuOptions();

        int choice;

        do {
            menu.displayMenu();
            System.out.println("***********************");
            System.out.println("Please enter a number between 1 and 5: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number, pleasse try again: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            menu.handleMenuOption(choice);

        } while (choice != 5);

        scanner.close();
    }
}
