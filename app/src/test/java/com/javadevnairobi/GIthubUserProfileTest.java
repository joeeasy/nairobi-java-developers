package com.javadevnairobi;

import com.google.gson.annotations.SerializedName;
import com.javadevnairobi.model.GithubUserProfile;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GIthubUserProfileTest {
    private String url = "http://helloworld.com";
    private String followers = "23";
    private String following = "24";
    private String name = "jehonadab okpukoro";
    private String bio = "I am a software developer";
    private String repos = "api.github.com";
    private  String username ="joeeasy";
    private String imageUrl = "https://image.com/image";

    private GithubUserProfile githubUserProfile = new GithubUserProfile(url, followers, following, name, bio,repos,username, imageUrl);

    @Test
    public void testProfileModel() {
        assertEquals(url, githubUserProfile.getUrl());
        assertEquals(followers, githubUserProfile.getFollowers());
        assertEquals(following, githubUserProfile.getFollowing());
        assertEquals(name, githubUserProfile.getName());
        assertEquals(bio, githubUserProfile.getBio());
        assertEquals(username, githubUserProfile.getUsername());
        assertEquals(imageUrl, githubUserProfile.getImageUrl());
    }
}
