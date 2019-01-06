package com.javadevnairobi.view;

import com.javadevnairobi.model.GithubUserRepo;

import java.util.List;

public interface GithubRepoView {
    void githubRepoReady(List<GithubUserRepo> githubUserRepo);
}
