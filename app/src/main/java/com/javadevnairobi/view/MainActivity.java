package com.javadevnairobi.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.javadevnairobi.R;
import com.javadevnairobi.model.GithubUsers;
import com.javadevnairobi.presenter.GithubUserPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GithubUserView {

    public static final String EXTRA_MESSAGE = "com.javadevnairobi.MESSAGE";
    private static final String TAG = "MainActivity";

//    variables
    private ArrayList<String> usernames = new ArrayList<>();
    private  ArrayList<String> imageUrls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GithubUserPresenter githubUserPresenter = new GithubUserPresenter(this);
        githubUserPresenter.getUsers();

    }
    @Override
    public void githubUserReady(List<GithubUsers> githubUsers) {
        for (GithubUsers githubUser: githubUsers) {
            imageUrls.add(githubUser.getImageUrl());
            usernames.add(githubUser.getLogin());
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(usernames, imageUrls, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

