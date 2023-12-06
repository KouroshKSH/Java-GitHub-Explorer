package com.javagithubexplorer.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaGitHubExplorerApplication {
	private static final Logger logger = LoggerFactory.getLogger(JavaGitHubExplorerApplication.class);

	public static void main(String[] args) {
//		System.out.println("\n\n>>>\tFirst attempt at login/signup interaction...\n\n");
//		logger.info("\n<!> first log test <!>\n");
		SpringApplication.run(JavaGitHubExplorerApplication.class, args);
	}

}
