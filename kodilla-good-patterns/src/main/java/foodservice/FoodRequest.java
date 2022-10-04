package com.kodilla.good.patterns.foodservice;


import java.time.LocalDateTime;

public class FoodRequest {

    private String producerName;
    private LocalDateTime dateOfOrder;
    private Food food;

    public FoodRequest(String producerName, LocalDateTime dateOfOrder, Food food) {
        this.producerName = producerName;
        this.dateOfOrder = dateOfOrder;
        this.food = food;
    }

    public String getProducerName() {
        return producerName;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public Food getFood () {
        return food;
    }

    public String toString () {
        return producerName + " " + dateOfOrder + " " + food + ".";
    }
}
