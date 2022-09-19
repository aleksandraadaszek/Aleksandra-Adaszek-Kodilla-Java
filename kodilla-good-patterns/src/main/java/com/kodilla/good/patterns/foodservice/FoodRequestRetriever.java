package com.kodilla.good.patterns.foodservice;


import java.time.LocalDateTime;

public class FoodRequestRetriever {

    public FoodRequest retrieveFoodData () {
        Producers producers = new Producers("Healthy Food");

        LocalDateTime dateOfOrder = LocalDateTime.of(2022, 11, 18, 10, 22);

        Food food = new Food ("Apples", 10, 0.80);

        return new FoodRequest(producers,dateOfOrder, food);
    }
}
