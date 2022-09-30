package com.kodilla.good.patterns.foodservice;



public class HealthyShop implements FoodProducer {

    String name;
    FoodRequest foodRequest;

    public HealthyShop (FoodRequest foodRequest, String name) {
        this.foodRequest = foodRequest;
        this.name = name;
    }

    public void process (FoodRequest foodRequest) {
        FoodOrderService foodOrderService = new FoodOrderService();
        foodOrderService.soldFood("Healthy Shop",foodRequest.getFood(),foodRequest.getDateOfOrder());
    }

    public FoodRequest getFoodRequest () {
        return foodRequest;
    }
    public String getName () {
        return name;
    }
}

