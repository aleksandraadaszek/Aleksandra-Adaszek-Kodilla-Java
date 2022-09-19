package com.kodilla.good.patterns.foodservice;


import java.time.LocalDateTime;

public class FoodOrderService {

    public boolean soldFood (Producers producers, Food food, LocalDateTime dateOfOrder) {
        System.out.println("On " + dateOfOrder.toString() + " " + producers.getProducerName() + " " + "sold: " +
                            food.getAmount() + " " + "of " + food.getName() + " " + "for " +
                            food.getPrice() + " " + "each, and so the total price is: " + food.calculateFinalPrice());

        return true;

    }
}
