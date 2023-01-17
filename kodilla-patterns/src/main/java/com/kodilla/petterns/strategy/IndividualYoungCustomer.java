package com.kodilla.petterns.strategy;


public class IndividualYoungCustomer extends Customer {

    public IndividualYoungCustomer(String name) {
        super(name);
        this.buyPredictor= new AggressivePredictor();
    }
}
