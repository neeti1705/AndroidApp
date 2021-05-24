package com.example.project1;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Post {
    @SerializedName("text")
    public String text;
    @SerializedName("image")
    public String image;
    @SerializedName("likes")
    public Integer likes;
    @SerializedName("link")
    public String link;
    @SerializedName("tag")
    public ArrayList<String> tag;
    @SerializedName("publishDate")
    public String publishDate;


    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public Integer getLikes() {
        return likes;
    }

    public String getLink() {
        return link;
    }

    public ArrayList<String> getTag() {
        return tag;
    }

    public String getPublishDate() {
        return publishDate;
    }
}
