package com.javadevnairobi.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUsersResponse {
    @SerializedName("items")
    private ArrayList<GithubUsers> githubUsersList;
    private static final String TAG = "GithubUsersResponse";

    public GithubUsersResponse(ArrayList<GithubUsers> githubUsersList) {
        this.githubUsersList = githubUsersList;
        android.util.Log.d(TAG, "GithubUsersResponse() returned ================: " +  githubUsersList);
    }

    public ArrayList<GithubUsers> getGithubUsersList() {
        return githubUsersList;
    }


}
