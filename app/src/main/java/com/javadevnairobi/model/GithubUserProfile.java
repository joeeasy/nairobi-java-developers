package com.javadevnairobi.model;

import com.google.gson.annotations.SerializedName;

public class GithubUserProfile {
    @SerializedName("html_url")
    private String url;
    @SerializedName("followers")
    private String followers;
    @SerializedName("following")
    private String following;
    @SerializedName("name")
    private String name;
    @SerializedName("bio")
    private String bio;
    @SerializedName("public_repos")
    private String repos;
    @SerializedName("login")
    private  String username;
    @SerializedName("avatar_url")
    private String imageUrl;

    public GithubUserProfile(String url, String followers, String following, String name, String bio, String repos, String username, String imageUrl) {
        this.url = url;
        this.followers = followers;
        this.following = following;
        this.name = name;
        this.bio = bio;
        this.repos = repos;
        this.username = username;
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getRepos() {
        return repos;
    }

    public String getUsername() {
        return username;
    }
}
