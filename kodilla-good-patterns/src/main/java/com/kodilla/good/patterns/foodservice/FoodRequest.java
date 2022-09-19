package com.kodilla.good.patterns.foodservice;


import java.time.LocalDateTime;

public class FoodRequest {

    private Producers producers;
    private LocalDateTime dateOfOrder;
    private Food food;

    public FoodRequest(Producers producers, LocalDateTime dateOfOrder, Food food) {
        this.producers = producers;
        this.dateOfOrder = dateOfOrder;
        this.food = food;
    }

    public Producers getProducers() {
        return producers;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public Food getFood () {
        return food;
    }
}
