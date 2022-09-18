package com.kodilla.good.patterns.challenges;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class SellingDto {

    private Client client;
    private boolean isSold;


    public SellingDto(Client client, boolean isSold) {
        this.client = client;
        this.isSold = isSold;
    }

    public Client getClient() {
        return client;
    }

    public boolean isSold() {
        return isSold;
    }

}
