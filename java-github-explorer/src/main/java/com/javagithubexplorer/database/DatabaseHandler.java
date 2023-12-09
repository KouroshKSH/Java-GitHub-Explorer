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
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

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
	
	public boolean isUsernameUnique(String username) {
		// return true if the username is unique and is not repeated in the database
        return usersCollection.find(Filters.eq("username", username))
                             .projection(Projections.include("_id"))
                             .limit(1)
                             .first() == null;
    }
	
	public boolean validateUserPass(String username, String password) {
		// return true if the given password for given user actually matches the password stored in the DB
        Document user = usersCollection.find(Filters.eq("username", username)).first();

        if (user != null) {
            String storedPassword = user.getString("password");
            return storedPassword.equals(password);
        }
        // if the user is not found, then it's also false (can't log in)
        return false;
    }
	
	public List<Document> findRepoByTitle(String title) {
	    // Create a filter to search by name
	    Bson filter = Filters.eq("title", title);
	    // Execute the find query
	    List<Document> results = new ArrayList<>();
	    collection.find(filter).into(results);
	    return results;
	}

	public List<Document> findRepoByUrl(String url) {
	    // Create a filter to search by URL
	    Bson filter = Filters.eq("url", url);
	    // Execute the find query
	    List<Document> results = new ArrayList<>();
	    collection.find(filter).into(results);
	    return results;
	}

	public List<Document> findRepoByStars(String stars) {
	    // Create a filter to search by stars
	    Bson filter = Filters.eq("stars", stars);
	    // Execute the find query
	    List<Document> results = new ArrayList<>();
	    collection.find(filter).into(results);
	    return results;
	}

	public void printRandomRepositories() {
        // Aggregation pipeline for randomly selecting 5 documents
        List<Document> randomEntries = collection.aggregate(
            Arrays.asList(
                Aggregates.sample(5)
            )
        ).into(new java.util.ArrayList<>());

        // Print the retrieved documents
        for (Document entry : randomEntries) {
            System.out.println(entry.toJson());
        }
    }
}