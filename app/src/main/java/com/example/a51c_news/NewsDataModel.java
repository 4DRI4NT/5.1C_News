package com.example.a51c_news;


public class NewsDataModel {
    private int id, image;
    private String title, description;

    //structure of data model
    public NewsDataModel(int id, String title, String description, int image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getImage() {
        return image;
    }
}
