package com.kodilla.good.patterns.challenges;


import java.time.LocalDate;

public class SellingDto {

    private Client client;
    private boolean isSold;
    private LocalDate dateOfOrder;
    private Products products;


    public SellingDto(Client client, boolean isSold, LocalDate dateOfOrder, Products products) {
        this.client = client;
        this.isSold = isSold;
        this.dateOfOrder = dateOfOrder;
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public boolean isSold() {
        return isSold;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public Products getProducts() {
        return products;
    }
}
