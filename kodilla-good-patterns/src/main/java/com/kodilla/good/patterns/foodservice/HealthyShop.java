package com.kodilla.good.patterns.foodservice;



public class HealthyShop implements FoodProducer {

    FoodRequest foodRequest;

    public HealthyShop (FoodRequest foodRequest) {
        this.foodRequest = foodRequest;
    }

    public void process (FoodRequest foodRequest) {
       System.out.println (" The order for " + foodRequest + " has been just sent.");
       FoodOrderService foodOrderService = new FoodOrderService();
       foodOrderService.soldFood("Healthy Food Shop",foodRequest.getFood(),foodRequest.getDateOfOrder());
    }

    public FoodRequest getFoodRequest () {
        return foodRequest;
    }
}

