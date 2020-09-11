package com.example.imgretro;

import com.google.gson.annotations.SerializedName;

public class RetroPhoto {

    @SerializedName("author")
    private String author;

    public RetroPhoto() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RetroPhoto(String author, String image) {
        this.author = author;
        this.image = image;
    }

    @SerializedName("download_url")
    private String image;

}
