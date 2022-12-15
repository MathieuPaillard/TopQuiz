package com.helloweed.topquiz.model;

public class User {
    String mFirstName;
    int mScore;

    public int getScore() {
        return mScore;
    }
    public void setScore(int score) {
        mScore = score;
    }
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }
}
