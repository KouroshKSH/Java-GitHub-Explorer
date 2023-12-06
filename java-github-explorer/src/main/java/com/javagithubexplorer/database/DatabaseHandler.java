/**
 * 
 */
package com.javagithubexplorer.database;

/**
 * A class responsible for interacting with the MongoDB database.
 * Methods to perform database operations like inserting a new user, querying users, etc.
 */

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseHandler {
	private final MongoClient mongoClient;
	private final MongoDatabase database;
	private final MongoCollection<Document> usersCollection;
	
	public DatabaseHandler() {
		// establish a connection to MongoDB
		mongoClient = MongoClients.create("mongodb://localhost:27017");
		database = mongoClient.getDatabase("Java_GitHub_Explorer");
		usersCollection = database.getCollection("Users");
	}
	
	public void createUser(String username, String password) {
		// create a doc for this user, and add it to the collection
		Document userDocument = new Document("username", username).append("password", password);
		usersCollection.insertOne(userDocument);
	}
	
	public boolean userExists(String username) {
		// check if the user exists in the database
		Document query = new Document("username", username);
		return usersCollection.find(query).first() != null;
	}
	
	public Document getUserByUsername(String username) {
		// return the doc of said user given its username
		return usersCollection.find(new Document("username", username)).first();
	}
	
	public boolean validatePassword(String username, String password) {
		// validate the entered password for said user
		Document query = new Document("username", username).append("password", password);
		return usersCollection.find(query).first() != null;
	}
}







