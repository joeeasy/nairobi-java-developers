package com.javadevnairobi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUsers {
    @SerializedName("name")
    private String name;

    @SerializedName("login")
    private String login;

    @SerializedName("bio")
    private String bio;

    @SerializedName("avatar_url")
    private String imageUrl;

    public GithubUsers(String name, String login, String bio, String imageUrl) {
        this.name = name;
        this.login = login;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getBio() {
        return bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
