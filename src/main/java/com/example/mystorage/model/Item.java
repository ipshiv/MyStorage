package com.example.mystorage.model;

import java.util.ArrayList;

public class Item {

    private String id, title, img, description;

    public Item(String id, String title, String img, String description) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
