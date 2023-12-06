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
	
	public void insertUsers(String username, String password) {
		// create a doc for this user, and add it to the collection
		Document userDocument = new Document("username", username).append("password", password);
		usersCollection.insertOne(userDocument);
	}
	
	public Document getUserByUsername(String username) {
		// return the doc of said user given its username
		return usersCollection.find(new Document("username", username)).first();
	}
}







