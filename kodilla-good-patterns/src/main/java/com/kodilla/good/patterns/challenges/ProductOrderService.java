package com.kodilla.good.patterns.challenges;


import java.time.LocalDate;

public class ProductOrderService {

    public boolean sold (final Client client, final LocalDate dateOfOrder, final Products products) {
        System.out.println("On "+ dateOfOrder.toString() + client.getClientNameAndSurname() + "has placed an order for: " + products.getAmount()+
                products.getName() + "at the price of "+ products.getPrice() + "and the total price is: " + products.calculateFinalPrice());

        return true;
    }
}
