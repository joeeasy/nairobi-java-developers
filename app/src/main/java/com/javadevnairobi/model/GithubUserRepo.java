package com.javadevnairobi.model;

import com.google.gson.annotations.SerializedName;

public class GithubUserRepo {
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("stargazers_count")
    private int stars;
    @SerializedName("watchers_count")
    private int watchers;
    @SerializedName("forks")
    private int folks;

    public GithubUserRepo(String name, String description, int stars, int watchers, int folks) {
        this.name = name;
        this.description = description;
        this.stars = stars;
        this.watchers = watchers;
        this.folks = folks;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStars() {
        return stars;
    }

    public int getWatchers() {
        return watchers;
    }

    public int getFolks() {
        return folks;
    }
}
