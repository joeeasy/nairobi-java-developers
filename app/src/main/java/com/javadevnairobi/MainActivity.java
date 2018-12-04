package com.javadevnairobi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.javadevnairobi.MESSAGE";
    private static final String TAG = "MainActivity";

//    variables
    private ArrayList<String> usernames = new ArrayList<>();
    private  ArrayList<String> imageUrls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");
        imageUrls.add("https://picsum.photos/200/300/?random");
        imageUrls.add("https://picsum.photos/200/300/?random");
        imageUrls.add("https://picsum.photos/200/300/?random");
        imageUrls.add("https://picsum.photos/200/300/?random");
        imageUrls.add("https://picsum.photos/200/300/?random");
        usernames.add("joeeasy");
        usernames.add("johngorithm");
        usernames.add("sam");
        usernames.add("danieladek");
        usernames.add("ascii-dev");
        initRecyclerView();
    }
    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Log.d(TAG, "initRecyclerView() returned: " + recyclerView);
//        Log.d(TAG, "initRecyclerView() returned: " + getIntent());
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(usernames, imageUrls, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

