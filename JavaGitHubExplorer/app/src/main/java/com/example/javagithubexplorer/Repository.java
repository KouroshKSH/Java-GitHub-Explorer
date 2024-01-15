package com.example.javagithubexplorer;

public class Repository {
    private String title;
    private String stars;
    private String description;

    private String url;

    public Repository(String title, String stars, String description, String url) {
        this.title = title;
        this.stars = stars;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getStars() {
        return stars;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {return url;}
}
