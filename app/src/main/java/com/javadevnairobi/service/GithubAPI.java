package com.javadevnairobi.service;

import com.javadevnairobi.model.GithubUsers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubAPI {
    String BASE_URL = "https://api.github.com/";

    @GET("search/users?q=+language:java+location:nairobi");
    Call<List<GithubUsers>> getUsers();
}
