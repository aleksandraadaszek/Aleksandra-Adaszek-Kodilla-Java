package com.kodilla.good.patterns.challenges;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class SellingRequestRetriever {


    public SellRequest retrieveSellData() {
        Client client = new Client("Jan Kowalski");

        LocalDateTime dateOfOrder = LocalDateTime.of(2022, 9, 10, 8, 22);

        Products products = new Products("slippers", 2, 14.50);

        return new SellRequest(client, dateOfOrder, products);
    }
}
