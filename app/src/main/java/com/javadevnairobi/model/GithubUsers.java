package com.javadevnairobi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUsers {
    @SerializedName("name")
    private String name;

    @SerializedName("login")
    private String login;


    @SerializedName("avatar_url")
    private String imageUrl;

    @SerializedName("url")
    private  String url;
    @SerializedName("repos_url")
    private String repoUrl;

    public GithubUsers(String name, String login, String imageUrl, String url, String repoUrld) {
        this.name = name;
        this.login = login;
        this.imageUrl = imageUrl;
        this.url = url;
        this.repoUrl = repoUrl;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
