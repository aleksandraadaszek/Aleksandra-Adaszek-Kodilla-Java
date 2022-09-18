package com.kodilla.good.patterns.challenges;


import java.time.LocalDateTime;

public class SellingServiceClass implements SellingService{

    public boolean sell(Client client, LocalDateTime dateOfOrder, Products products) {
        System.out.println("The products have been sold.");
        return true;
    }
}
