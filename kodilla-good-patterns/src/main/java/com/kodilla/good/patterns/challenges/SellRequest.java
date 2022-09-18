package com.kodilla.good.patterns.challenges;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class SellRequest {

    private Client client;
    private LocalDateTime dateOfOrder;
    private Products products;


    public SellRequest(Client client, LocalDateTime dateOfOrder, Products products) {
        this.client = client;
        this.dateOfOrder = dateOfOrder;
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public Products getProducts() {
        return products;
    }
}
