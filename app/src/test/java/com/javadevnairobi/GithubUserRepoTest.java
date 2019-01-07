package com.javadevnairobi;

import com.google.gson.annotations.SerializedName;
import com.javadevnairobi.model.GithubUserRepo;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GithubUserRepoTest {
    private String name = "jehonadab okpukoro";
    private String description = "I am a software developer";
    private int stars = 2;
    private int watchers = 3;
    private int folks = 4;
    private GithubUserRepo githubUserRepo = new GithubUserRepo(name,description, stars,watchers,folks);


    @Test
    public void testRepoModel() {
        assertEquals(name, githubUserRepo.getName());
        assertEquals(description, githubUserRepo.getDescription());
        assertEquals(stars, githubUserRepo.getStars());
        assertEquals(watchers, githubUserRepo.getWatchers());
        assertEquals(folks, githubUserRepo.getFolks());
    }

}
