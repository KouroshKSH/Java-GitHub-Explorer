package com.javagithubexplorer.userinteraction;

import com.javagithubexplorer.database.DatabaseHandler;

import java.util.List;
import java.util.Scanner;

import org.bson.Document;

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
                    logIn();
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

    private void logIn() {
        System.out.println("\n> Log-in to your account.");
        String username;
        boolean userExists;
        boolean correctPassword;

        do {
            System.out.print("\n> Please enter your username: ");
            username = scanner.nextLine();

            userExists = databaseHandler.isUsernameUnique(username);
            if (userExists) {
            	// condition being true means that the username was unique, or non-existent in the DB
            	// so it's good for signing up, not logging in (can't log in with a non-existent username)
                System.out.printf("\n<!> The username '%s' doesn't exist. Please reenter your username:%n", username);
            }
        } while (userExists);

        System.out.println("\n> Username found. Enter your password.");
        do {
            System.out.print("\n> Enter your password: ");
            String password = scanner.nextLine();

            correctPassword = databaseHandler.validateUserPass(username, password);
            if (correctPassword) {
            	// passwords match
                System.out.println("\n>>> Successful login!");
            } else {
                System.out.println("\n<!> Wrong password. Please try again.");
            }
        } while (!correctPassword);
        
        // TODO:
        // replace the lines below with actual repo info with a collection like `Repositories` from MongoDB
        System.out.println("\nLog-in is done.");
        System.out.println("\n=====\n>>> This is the homepage...\n=====\n");
        DatabaseHandler dbHandler = new DatabaseHandler();
        System.out.println("\n> Printing a list of 5 random repositories:\n");
        dbHandler.printRandomRepositories(5);
        System.out.println("\n> Printing the list of repositories that have more than 5000 stars:\n");
        List<Document> result = dbHandler.filterReposWithStarsGEQ(5000);
        dbHandler.printRepositories(result);
    }

    
    
    private void signUp() {
    	// the sign-up phase of the welcome-screen
        System.out.println("\n> Let's create your account. Firstly, we should set your username.");
        String username;
        do {
        	// get the username
            System.out.print("\n> Please enter your desired username: ");
            username = scanner.nextLine();
            if (username.isEmpty()) {
            	// usernames should be at least one character long
            	System.out.println("\n<!> Username can't be an empty string. Please type in a valid username: ");
            }
            if (!databaseHandler.isUsernameUnique(username)) {
            	// no duplicate usernames are allowed
            	System.out.printf("\n<!> The username '%s' is taken. Please type in another username:%n", username);
            }
        } while (!databaseHandler.isUsernameUnique(username) || username.isEmpty());

        System.out.printf("\n>> The username '%s' is valid. You can now set your password.", username);
        String password;
        boolean notMatching = true; // represents the condition of passwords not matching
        do {
        	// get the password
            System.out.print("\n> Set your password: ");
            password = scanner.nextLine();
            if (password.isEmpty()) {
            	// passwords should be at least one character long
            	System.out.println("\n<!> Password can't be an empty string. Please type in a valid password: ");
            } else {
            	// password is not empty
            	System.out.print("Confirm your password: ");
                String confirmPassword = scanner.nextLine();

                if (password.equals(confirmPassword)) {
                    // passwords match, create user and add to database
                    databaseHandler.createUser(username, password);
                    System.out.println("\n\n>>> Account created successfully!");
                    notMatching = false;
                } else {
                    System.out.println("\n<!> Passwords don't match. Please try again.\n");
                }
            }
        } while (notMatching || password.isEmpty());
        
        System.out.println("\nSign-up is done.");
        System.out.println("\n=====\n>>> This is the homepage...\n=====\n");
        DatabaseHandler dbHandler = new DatabaseHandler();
        System.out.println("\n> Printing a list 4 of random repositories:\n");
        dbHandler.printRandomRepositories(4);
        System.out.println("\n> Printing the list of repositories that have more than 100'000 stars:\n");
        List<Document> result = dbHandler.filterReposWithStarsGEQ(100000);
        dbHandler.printRepositories(result);
    }
}
