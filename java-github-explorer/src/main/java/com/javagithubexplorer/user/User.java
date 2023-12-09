/**
 * 
 */
package com.javagithubexplorer.user;

/**
 * A class representing a user with attributes like username, password, etc.
 * Methods to handle user-related operations like creating, validating, and fetching user details.
 */

public class User {
	// for now, each user has only a username and a password
	// more attributes will be added in later stages
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// getters and setters
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// The `User` class remains solely responsible for representing user attributes, and not username and password checking
}
