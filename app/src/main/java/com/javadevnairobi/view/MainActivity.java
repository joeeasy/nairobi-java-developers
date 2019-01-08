package com.javadevnairobi.view;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.javadevnairobi.R;
import com.javadevnairobi.model.GithubUsers;
import com.javadevnairobi.presenter.GithubUserPresenter;
import com.javadevnairobi.utils.NetworkUtility;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GithubUserView {

    public static final String EXTRA_MESSAGE = "com.javadevnairobi.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.javadevnairobi.MESSAGE";

    private static final String TAG = "MainActivity";

//    variables
    private ArrayList<String> usernames = new ArrayList<>();
    private  ArrayList<String> imageUrls = new ArrayList<>();
    private ArrayList<String> url = new ArrayList<>();
    private ArrayList<String> repoUrl = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkUtility networkUtility = new NetworkUtility();

        if (networkUtility.isConnected(this)) {
            fetchUsers();
        } else {
            showConnectionError();
        }


    }
    public void fetchUsers() {
        final GithubUserPresenter githubUserPresenter = new GithubUserPresenter(this);
        githubUserPresenter.getUsers();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching users...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        swipeRefreshLayout = findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                githubUserPresenter.getUsers();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 10000);
            }
        });
    }
    public void showConnectionError() {

        Snackbar networkErrMessage = Snackbar.make(findViewById(R.id.main_activity), R.string.network_error, Snackbar.LENGTH_LONG);
        networkErrMessage.setAction(R.string.refreshText, new Refresh());
        networkErrMessage.show();

    }
    public class Refresh implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            fetchUsers();
        }
    }
    @Override
    public void githubUserReady(List<GithubUsers> githubUsers) {
        for (GithubUsers githubUser: githubUsers) {
            imageUrls.add(githubUser.getImageUrl());
            usernames.add(githubUser.getLogin());
        }
        initRecyclerView();
        progressDialog.dismiss();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(usernames, imageUrls, this);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}

