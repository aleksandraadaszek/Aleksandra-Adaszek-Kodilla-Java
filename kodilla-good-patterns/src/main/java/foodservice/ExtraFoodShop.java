package com.kodilla.good.patterns.foodservice;


public class ExtraFoodShop implements FoodProducer {

    FoodRequest foodRequest;

    public ExtraFoodShop (FoodRequest foodRequest ) {
        this.foodRequest = foodRequest;
    }

    public void process (FoodRequest foodRequest) {
        System.out.println("The order has been sent.");
    }

    public FoodRequest getFoodRequest () {
        return foodRequest;
    }

}

