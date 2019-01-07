package com.javadevnairobi;

import com.javadevnairobi.model.GithubUsers;
import com.javadevnairobi.model.GithubUsersResponse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GithubUsersResponseTest {
    private GithubUsersResponse githubUsersResponse;
    private ArrayList<GithubUsers> githubUsersList = new ArrayList<>();
    private GithubUsers githubUser1 = new GithubUsers("joeeasy", "http://facebook.com/joeeasy.png");
    private GithubUsers githubUser2 = new GithubUsers("johngorithm", "http://facebook.com/johngorithm.png");



    @Test
    public void testGithubUsersResponse() {
        githubUsersList.add(githubUser1);
        githubUsersList.add(githubUser2);
        githubUsersResponse  = new GithubUsersResponse(githubUsersList);
        githubUsersResponse.getGithubUsersList();
    }

}
