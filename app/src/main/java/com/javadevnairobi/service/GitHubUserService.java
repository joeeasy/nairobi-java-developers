package com.javadevnairobi.service;

import android.widget.Toast;

import com.javadevnairobi.model.GithubUsers;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;


public class GitHubUserService {
    //Creating a retrofit object
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GithubAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
            .build();
}
