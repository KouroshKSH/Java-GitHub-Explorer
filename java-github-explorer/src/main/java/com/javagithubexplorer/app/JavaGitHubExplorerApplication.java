package com.javagithubexplorer.app;

import com.javagithubexplorer.userinteraction.UserInteractionHandler;
import com.javagithubexplorer.database.DatabaseHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaGitHubExplorerApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaGitHubExplorerApplication.class, args);
		
		UserInteractionHandler userInteractionHandler = new UserInteractionHandler(new DatabaseHandler());
        userInteractionHandler.displayWelcomeMessage();
	}

}
