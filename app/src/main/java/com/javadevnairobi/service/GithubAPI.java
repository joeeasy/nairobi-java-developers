package com.javadevnairobi.service;

import com.javadevnairobi.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubAPI {
    @GET("search/users?q=+language:java+location:nairobi")
    Call<GithubUsersResponse> getGithubUsersList();
}
