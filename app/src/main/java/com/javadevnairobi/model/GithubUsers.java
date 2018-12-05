package com.javadevnairobi.model;

import com.google.gson.annotations.SerializedName;

public class GithubUsers {

    @SerializedName("name")
    private String name;

    @SerializedName("login")
    private String login;

    @SerializedName("bio")
    private String bio;

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getBio() {
        return bio;
    }
}
