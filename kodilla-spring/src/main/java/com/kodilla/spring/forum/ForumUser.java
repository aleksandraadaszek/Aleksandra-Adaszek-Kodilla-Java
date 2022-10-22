package com.kodilla.spring.forum;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForumUser {

    String username;

    public ForumUser() {
        username = "John Smith";
    }

    public String getUsername () {
        return username;
    }
}