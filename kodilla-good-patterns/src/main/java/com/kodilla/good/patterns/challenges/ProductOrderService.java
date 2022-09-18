package com.kodilla.good.patterns.challenges;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductOrderService {

    public boolean sold (Client client, LocalDateTime dateOfOrder, Products products) {
        System.out.println("On "+ dateOfOrder.toString() + " " + client.getClientNameAndSurname() + " " + "has placed an order for: " + products.getAmount()+ ' ' +
                products.getName() + " " +  "at the price of "+ products.getPrice() + " " +  "each, and so the total price is: " + products.calculateFinalPrice() + ".");

        return true;
    }
}
