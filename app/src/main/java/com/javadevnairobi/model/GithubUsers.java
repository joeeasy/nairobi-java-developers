package com.javadevnairobi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUsers {
    @SerializedName("login")
    private String login;


    @SerializedName("avatar_url")
    private String imageUrl;

    public GithubUsers(String login, String imageUrl) {
        this.login = login;
        this.imageUrl = imageUrl;
    }
    public String getLogin() {
        return login;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
