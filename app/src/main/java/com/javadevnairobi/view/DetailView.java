package com.javadevnairobi.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
 import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.javadevnairobi.R;
import com.javadevnairobi.model.GithubUserProfile;
import com.javadevnairobi.model.GithubUserRepo;
import com.javadevnairobi.model.GithubUsers;
import com.javadevnairobi.presenter.GithubRepoPresenter;
import com.javadevnairobi.presenter.GithubUserProfilePresenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.support.v4.view.MenuItemCompat.*;

public class DetailView extends AppCompatActivity implements GithubUserProfileView, GithubRepoView {
    private static final String TAG = "dd";
    private String linkToRepo;
    private ArrayList<String> repoName = new ArrayList<>();
    private ArrayList<String> repoDescription = new ArrayList<>();
    private ArrayList<Integer> star = new ArrayList<>();
    private ArrayList<Integer> watchers = new ArrayList<>();
    private ArrayList<Integer> folks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        linkToRepo = username;
        GithubUserProfilePresenter githubUserProfilePresenter = new GithubUserProfilePresenter(this);
        GithubRepoPresenter githubRepoPresenter = new GithubRepoPresenter(this);
        githubUserProfilePresenter.getUserProfile(username);
        githubRepoPresenter.getUserRepos(username);


    }
    @SuppressLint("CheckResult")
    @Override
    public void githubUserProfileReady(GithubUserProfile githubUserProfile) {
//        Display user's name
        TextView nameView = findViewById(R.id.name);
        nameView.setText(githubUserProfile.getName());
//    Displays username
        TextView usernameView = findViewById(R.id.username);
        usernameView.setText(githubUserProfile.getUsername());
//      Displays bio
        TextView bio = findViewById(R.id.bio);
        bio.setText(githubUserProfile.getBio());
//        Display number of followering, repos, and following
        TextView followers = findViewById(R.id.followers);
        TextView repos = findViewById(R.id.repos);
        TextView following = findViewById(R.id.following);
        ImageView profileImageView = findViewById(R.id.profile_image);

        followers.setText(githubUserProfile.getFollowers());
        repos.setText(githubUserProfile.getRepos());
        following.setText(githubUserProfile.getFollowing());
        Glide.with(this).asBitmap()
                .load(githubUserProfile.getImageUrl())
                .into(profileImageView);

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RepoViewAdapter repoViewAdapter = new RepoViewAdapter(repoName, repoDescription, star, watchers, folks, this);
        recyclerView.setAdapter(repoViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void githubRepoReady(List<GithubUserRepo> githubUserRepo) {
        for (GithubUserRepo githubUserRepo1: githubUserRepo) {
            repoName.add(githubUserRepo1.getName());
            star.add(githubUserRepo1.getStars());
            watchers.add(githubUserRepo1.getWatchers());
            folks.add(githubUserRepo1.getFolks());
            if(githubUserRepo1.getDescription() != null) {
                repoDescription.add(githubUserRepo1.getDescription());
            } else {
                repoDescription.add("No repo description");
            }
        }
        initRecyclerView();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.share_button, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_share:
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_TEXT, "Hey checkout the profile of this awesome developer " + "https://github.com/"+linkToRepo );
                startActivity(Intent.createChooser(i,"Share Via"));
                break;
        }
        Toast.makeText(getApplicationContext(), "You click on menu share", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);

    }

}
