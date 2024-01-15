//package com.example.javagithubexplorer;
//
////public class MongoDBCollection {
////}
//
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//
//class MongoDBConnection {
//    private static final String SERVER_ADDRESS = "localhost";
//    private static final int SERVER_PORT = 27017;
//    private static final String DATABASE_NAME = "JavaGitHubExplorer";
//
//    private static MongoClient mongoClient;
//    private static MongoDatabase database;
//
//    public static MongoDatabase connect() {
//        if (database == null) {
//            mongoClient = MongoClients.create("mongodb://" + SERVER_ADDRESS + ":" + SERVER_PORT);
//            database = mongoClient.getDatabase(DATABASE_NAME);
//        }
//        return database;
//    }
//
//    public static void disconnect() {
//        if (mongoClient != null) {
//            mongoClient.close();
//        }
//    }
//}
