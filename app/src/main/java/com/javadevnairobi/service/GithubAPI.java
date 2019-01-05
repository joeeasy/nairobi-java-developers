package com.javadevnairobi.service;

import com.javadevnairobi.model.GithubUserProfile;
import com.javadevnairobi.model.GithubUserRepo;
import com.javadevnairobi.model.GithubUsersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GithubAPI {
    @GET("search/users?q=+language:java+location:nairobi")
    Call<GithubUsersResponse> getGithubUsersList();

    @GET("/users/{username}?client_id=694ce0aafdfbc47ad583&client_secret=58709f1741ce72e8102a05b41412b38750bf1cd0")
    Call <GithubUserProfile> getUserProfile(@Path("username") String username);
    @GET("/users/{username}/repos?client_id=694ce0aafdfbc47ad583&client_secret=58709f1741ce72e8102a05b41412b38750bf1cd0")
    Call <List<GithubUserRepo>> getUserRepos(@Path("username") String username);

}
