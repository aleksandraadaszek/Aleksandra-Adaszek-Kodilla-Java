package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int idNumber;
    private final String userNickname;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(final int idNumber, final String userNickname, final char sex, final int year, final int month, final int day, final int numberOfPosts) {
        this.idNumber = idNumber;
        this.userNickname = userNickname;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.numberOfPosts = numberOfPosts;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" + "idNumber " + idNumber + '\'' + ", userNickname = " + userNickname + '\'' + ",sex = " + sex + ",dateOfBirth='" + dateOfBirth + '\'' + ",numberOfPosts = " + numberOfPosts + '\'' + '}';
    }

}

