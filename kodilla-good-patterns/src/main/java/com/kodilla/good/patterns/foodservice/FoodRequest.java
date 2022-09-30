package com.kodilla.good.patterns.foodservice;


import java.time.LocalDateTime;

public class FoodRequest {

    private FoodProducer name;
    private LocalDateTime dateOfOrder;
    private Food food;

    public FoodRequest(FoodProducer name, LocalDateTime dateOfOrder, Food food) {
        this.name = name;
        this.dateOfOrder = dateOfOrder;
        this.food = food;
    }

    public FoodProducer getName() {
        return name;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public Food getFood () {
        return food;
    }
}
