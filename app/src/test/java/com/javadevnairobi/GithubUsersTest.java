package com.javadevnairobi;

import com.javadevnairobi.model.GithubUsers;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GithubUsersTest {
    private String login = "joeeasy";
    private String imageUrl = "http://joeeasy.com/joeeasy.png";
    private  GithubUsers githubUsers = new GithubUsers(login, imageUrl);

    @Test
    public void checkForUsername(){
        assertEquals(login, githubUsers.getLogin());
    }
    @Test
    public void checkForImageUrl(){
        assertEquals(imageUrl, githubUsers.getImageUrl());
    }

}
