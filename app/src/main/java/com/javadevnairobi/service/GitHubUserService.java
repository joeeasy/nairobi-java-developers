package com.javadevnairobi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GitHubUserService {

    public GithubAPI getGithubApi() {
        String BASE_URL = "https://api.github.com/";
        //Creating a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(GithubAPI.class);
    }


}
