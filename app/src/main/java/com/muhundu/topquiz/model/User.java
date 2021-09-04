package com.muhundu.topquiz.model;

public class User {
private String mFirstName;

    public String getFirstName() {
        return this.mFirstName;
    }

    public void setFirstName(final String firstName) {
        this.mFirstName = firstName;
    }

    @Override
    public String toString() {
        return "User{" +
                "mFirstname='" + mFirstName + '\'' +
                '}';
    }
}
