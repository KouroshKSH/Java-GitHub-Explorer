package com.javagithubexplorer.userinteraction;

import com.javagithubexplorer.database.DatabaseHandler;

import java.util.Scanner;

public class UserInteractionHandler {
    private final Scanner scanner;
    private final DatabaseHandler databaseHandler;

    public UserInteractionHandler(DatabaseHandler databaseHandler) {
        this.scanner = new Scanner(System.in);
        this.databaseHandler = databaseHandler;
    }

    public void displayWelcomeMessage() {
    	System.out.println("\n> Welcome to the Java GitHub Explorer App! You can:");
    	System.out.println("\t1. Log-in");
    	System.out.println("\t2. Sign-up");
    	System.out.print("\n> Please choose one of the options by entering their number or name: ");
    	
    	boolean validChoice = false;

        while (!validChoice) {
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "1":
                case "one":
                case "login":
                case "log-in":
                    validChoice = true;
                    // Implement login process
                    break;
                case "2":
                case "two":
                case "signup":
                case "sign-up":
                    validChoice = true;
                    signUp();
                    break;
                default:
                    System.out.println("\n<!> Invalid choice! Please enter 1 or 2: ");
                    break;
            }
        }
    }

    private void signUp() {
        System.out.println("\n> Let's create your account. Firstly, we should set your username.");
        String username;
        do {
            System.out.print("\n> Please enter your desired username: ");
            username = scanner.nextLine();
            if (username.isEmpty()) {
            	System.out.println("\n<!> Username can't be an empty string. Please type in a valid username: ");
            }
            if (!databaseHandler.isUsernameUnique(username)) {
            	System.out.printf("\\n<!> The username '%s' is taken. Please type in another username:%n", username);
            }
        } while (!databaseHandler.isUsernameUnique(username) || username.isEmpty());

        System.out.println("You can now set your password:");
        String password;
        boolean notMatching = true; // represents the condition of passwords not matching
        do {
            System.out.print("\n> Set your password: ");
            password = scanner.nextLine();
            if (password.isEmpty()) {
            	System.out.println("\n<!> Password can't be an empty string. Please type in a valid password: ");
            }

            System.out.print("Confirm your password: ");
            String confirmPassword = scanner.nextLine();

            if (password.equals(confirmPassword)) {
                // Passwords match, create user and add to database
                databaseHandler.createUser(username, password);
                System.out.println("\n\n>>> Account created successfully!");
                notMatching = false;
//                break;
            } else {
                System.out.println("\n<!> Passwords don't match. Please try again.\n");
            }
        } while (notMatching || password.isEmpty());
        System.out.println("\nSign-up is done.");
        System.out.println("\n=====\n>>> This is the homepage...\n=====\n");
        System.out.println("\n1. title: \t start: \t URL:");
        System.out.println("\n2. title: \t start: \t URL:");
        System.out.println("\n3. title: \t start: \t URL:");
    }
}
