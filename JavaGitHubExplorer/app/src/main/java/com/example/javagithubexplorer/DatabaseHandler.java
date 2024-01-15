////package com.example.javagithubexplorer;
////
////public class DatabaseHandler {
////}
//
//
///**
// *
// */
////package com.javagithubexplorer.database;
////
///**
// * A class responsible for interacting with the MongoDB database.
// * Methods to perform database operations like inserting a new user, querying users, etc.
// */
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.bson.Document;
//import org.bson.conversions.Bson;
//
//import com.mongodb.client.model.Aggregates;
//import com.mongodb.client.model.Filters;
//import com.mongodb.client.model.Projections;
//
//public class DatabaseHandler {
//    private final MongoClient mongoClient;
//    private final MongoDatabase database;
//    private final MongoCollection<Document> usersCollection;
//    private final MongoCollection<Document> reposCollection;
//
//    public DatabaseHandler() {
//        // establish a connection to MongoDB
//        mongoClient = MongoClients.create("mongodb://localhost:27017");
//        database = mongoClient.getDatabase("Java_GitHub_Explorer");
//        usersCollection = database.getCollection("Users");
//        reposCollection = database.getCollection("Repositories");
//    }
//
//    public void createUser(String username, String password) {
//        // create a doc for this user, and add it to the collection
//        Document userDocument = new Document("username", username).append("password", password);
//        usersCollection.insertOne(userDocument);
//    }
//
//    public boolean userExists(String username) {
//        // check if the user exists in the database
//        Document query = new Document("username", username);
//        return usersCollection.find(query).first() != null;
//    }
//
//    public Document getUserByUsername(String username) {
//        // return the doc of said user given its username
//        return usersCollection.find(new Document("username", username)).first();
//    }
//
//    public boolean validatePassword(String username, String password) {
//        // validate the entered password for said user
//        Document query = new Document("username", username).append("password", password);
//        return usersCollection.find(query).first() != null;
//    }
//
//    public boolean isUsernameUnique(String username) {
//        // return true if the username is unique and is not repeated in the database
//        return usersCollection.find(Filters.eq("username", username))
//                .projection(Projections.include("_id"))
//                .limit(1)
//                .first() == null;
//    }
//
//    public boolean validateUserPass(String username, String password) {
//        // return true if the given password for given user actually matches the password stored in the DB
//        Document user = usersCollection.find(Filters.eq("username", username)).first();
//
//        if (user != null) {
//            String storedPassword = user.getString("password");
//            return storedPassword.equals(password);
//        }
//        // if the user is not found, then it's also false (can't log in)
//        return false;
//    }
//
//
//    public List<Document> filterReposWithStarsGEQ(int starsThreshold) {
//        // Aggregation pipeline for filtering repositories with stars greater than the threshold
//        List<Bson> pipeline = Arrays.asList(
//                Aggregates.match(Filters.gt("stars", starsThreshold)),
//                Aggregates.project(Projections.excludeId())
//        );
//
//        // Execute the aggregation query
//        List<Document> results = new ArrayList<>();
//        reposCollection.aggregate(pipeline).into(results);
//        return results;
//    }
//
//
//
//    public List<Document> findRepoByTitle(String title) {
//        // this function finds the repository that has a specific title
//        Bson filter = Filters.eq("title", title); // create a filter to search by name
//        List<Document> results = new ArrayList<>();
//        reposCollection.find(filter).into(results);
//        return results;
//    }
//
//    public List<Document> findRepoByUrl(String url) {
//        // this function finds the repository with a given URL
//        Bson filter = Filters.eq("url", url); // create a filter to search by URL
//        List<Document> results = new ArrayList<>();
//        reposCollection.find(filter).into(results);
//        return results;
//    }
//
//    public List<Document> findRepoByStars(int stars) {
//        // this function finds repositories with a specific number of stars
//        Bson filter = Filters.eq("stars", stars); // create a filter to search by stars
//        List<Document> results = new ArrayList<>();
//        reposCollection.find(filter).into(results);
//        return results;
//    }
//
//
//
//    public List<Document> getRandomRepositories(int num) {
//        // Aggregation pipeline for randomly selecting `num` number of documents
//        List<Document> randomEntries = reposCollection.aggregate(
//                Arrays.asList(
//                        Aggregates.sample(num)
//                )
//        ).into(new java.util.ArrayList<>());
//
//        // Return the retrieved documents
//        return randomEntries;
//    }
//
//
//    public void printRepositories(List<Document> repositories) {
//        // Check if the repositories list is empty
//        if (repositories.isEmpty()) {
//            System.out.println("<!> No results to display <!>");
//        } else {
//            // Print repositories if the list is not empty
//            for (int i = 0; i < repositories.size(); i++) {
//                Document repo = repositories.get(i);
//
//                // extract details dynamically
//                String title = repo.getString("title");
//                int stars = repo.getInteger("stars");
//                String url = repo.getString("url");
//
//                System.out.printf("%d. title: %s, number of stars: %d, URL: %s%n", i + 1, title, stars, url);
//
//                // Additional logic for future attributes
////	            for (String key : repo.keySet()) {
////	                if (!key.equals("title") && !key.equals("stars") && !key.equals("url")) {
////	                    System.out.printf("   %s: %s%n", key, repo.get(key));
////	                }
////	            }
//            }
//        }
//        System.out.print("\n");
//    }
//
//
//}