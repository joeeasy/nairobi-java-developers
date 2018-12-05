package com.javadevnairobi.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GithubUsersResponse {
    @SerializedName("items")
    List<GithubUsers> githubUsersList;
    public  GithubUsersResponse () {
        githubUsersList = new ArrayList<GithubUsers>();
    }
    public static GithubUsersResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        GithubUsersResponse githubUsersResponse = gson.fromJson(response, GithubUsersResponse.class);
        return githubUsersResponse;
    }
}
