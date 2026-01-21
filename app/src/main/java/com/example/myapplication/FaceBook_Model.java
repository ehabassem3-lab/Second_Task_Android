package com.example.myapplication;

public class FaceBook_Model  {
    int ProfileImage;
    String ProfileName;

    public int getProfileImage() {
        return ProfileImage;
    }

    public String getProfileName() {
        return ProfileName;
    }

    public FaceBook_Model(int profileImage, String profileName) {
        ProfileImage = profileImage;
        ProfileName = profileName;
    }
}
