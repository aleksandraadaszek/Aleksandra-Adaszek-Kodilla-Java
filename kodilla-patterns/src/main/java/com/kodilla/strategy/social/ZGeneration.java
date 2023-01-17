package com.kodilla.strategy.social;



public class ZGeneration extends User{

    public ZGeneration(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
