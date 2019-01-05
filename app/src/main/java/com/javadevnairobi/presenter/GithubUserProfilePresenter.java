package com.javadevnairobi.presenter;

import android.util.Log;

import com.javadevnairobi.model.GithubUserProfile;
import com.javadevnairobi.service.GitHubUserService;
import com.javadevnairobi.view.GithubUserProfileView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class GithubUserProfilePresenter {
    private GithubUserProfileView githubUserProfileView;
    private GitHubUserService gitHubUserService;

    public GithubUserProfilePresenter(GithubUserProfileView githubUserProfileView) {
        this.githubUserProfileView = githubUserProfileView;
        if(this.gitHubUserService == null) {
            this.gitHubUserService = new GitHubUserService();
        }
    }

    public void getUserProfile(String username) {
        this.gitHubUserService
                .getGithubApi()
                .getUserProfile(username)
                .enqueue(new Callback<GithubUserProfile>() {
                    @Override
                    public void onResponse(Call<GithubUserProfile> call, Response<GithubUserProfile> response) {
                        GithubUserProfile githubUserProfile = response.body();
                        if (githubUserProfile != null && githubUserProfile.getName() != null) {
                            githubUserProfileView.githubUserProfileReady(githubUserProfile);
                        }

                    }

                    @Override
                    public void onFailure(Call<GithubUserProfile> call, Throwable t) {
                        Log.d(TAG, "onFailure() returned: ====>>>>>>>>>>>>>>>>> " + t);
                    }
                });
    }

}
