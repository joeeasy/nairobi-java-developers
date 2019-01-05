package com.javadevnairobi.presenter;

import android.util.Log;

import com.javadevnairobi.model.GithubUserProfile;
import com.javadevnairobi.model.GithubUserRepo;
import com.javadevnairobi.service.GitHubUserService;
import com.javadevnairobi.view.GithubRepoView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class GithubRepoPresenter {
    private GithubRepoView githubRepoView;
    private GitHubUserService gitHubUserService;

    public GithubRepoPresenter(GithubRepoView githubRepoView) {
        this.githubRepoView = githubRepoView;

        if(this.gitHubUserService == null) {
            this.gitHubUserService = new GitHubUserService();
        }
    }
    public void getUserRepos(String username) {
        Log.d(TAG, "======== I am getting here oh =========");
        this.gitHubUserService
                .getGithubApi()
                .getUserRepos(username)
                .enqueue(new Callback<List<GithubUserRepo>>() {
                    @Override
                    public void onResponse(Call<List<GithubUserRepo>> call, Response<List<GithubUserRepo>> response) {

                        List <GithubUserRepo> githubUserRepo = response.body();
                        Log.d(TAG, "================ its not showing uo here " + githubUserRepo);
                        githubRepoView.githubRepoReady(githubUserRepo);

                    }

                    @Override
                    public void onFailure(Call<List<GithubUserRepo>> call, Throwable t) {

                        Log.d(TAG, "==== could not process request " + t);
                    }
                });
    }
}
