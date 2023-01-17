package com.kodilla.strategy.social;


public class TwitterPublisher implements SocialPublisher{

    @Override
    public String share() {
        return "Using Twitter";
    }
}
