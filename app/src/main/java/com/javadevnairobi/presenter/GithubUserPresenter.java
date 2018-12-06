package com.javadevnairobi.presenter;

import android.util.Log;

import com.javadevnairobi.model.GithubUsers;
import com.javadevnairobi.model.GithubUsersResponse;
import com.javadevnairobi.service.GitHubUserService;
import com.javadevnairobi.view.GithubUserView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class GithubUserPresenter {
    private GithubUserView githubUserView;
    private GitHubUserService gitHubUserService;

    public GithubUserPresenter (GithubUserView view) {
        this.githubUserView = view;

        if(this.gitHubUserService == null) {
            this.gitHubUserService = new GitHubUserService();
        }
    }

    public void getUsers() {
        gitHubUserService
                .getGithubApi()
                .getGithubUsersList()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        GithubUsersResponse githubUsersResponse = response.body();
                        if (githubUsersResponse != null && githubUsersResponse.getGithubUsersList() != null) {
                            List<GithubUsers> result = githubUsersResponse.getGithubUsersList();
                            githubUserView.githubUserReady(result);
                        }
                    }
                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure() returned: " + t);
                    }
                });
    }
}
