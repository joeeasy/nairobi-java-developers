package com.javadevnairobi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUsers implements Parcelable {
    @SerializedName("login")
    private String login;


    @SerializedName("avatar_url")
    private String imageUrl;

    public GithubUsers(String login, String imageUrl) {
        this.login = login;
        this.imageUrl = imageUrl;
    }

    protected GithubUsers(Parcel in) {
        login = in.readString();
        imageUrl = in.readString();
    }

    public static final Parcelable.Creator<GithubUsers> CREATOR = new Parcelable.Creator<GithubUsers>() {
        @Override
        public GithubUsers createFromParcel(Parcel in) {
            return new GithubUsers(in);
        }

        @Override
        public GithubUsers[] newArray(int size) {
            return new GithubUsers[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(imageUrl);
    }

    public String getLogin() {
        return login;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
